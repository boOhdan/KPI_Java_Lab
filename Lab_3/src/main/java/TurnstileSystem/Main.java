package TurnstileSystem;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Register register =new Register();
        Turnstile turnstile =new Turnstile();
        register.turnstiles.add(turnstile);

        //while (true){
        try{
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");

            Date startDate1 =format1.parse("2020/01/22");
            Date endDate1 =format1.parse("2020/03/12");

            Card timeCard =new TimeCard(1,startDate1,endDate1);

            System.out.println(timeCard.toString());

            System.out.println("Обиріть операцію :\n1) Створити картку \n2) Отриамти дані про картку \n3) Заблокувати картку " +
                    "\n4) Розблокувати картку \n5) Пройти турнікет  \n6) Видати дані \n7) Змінити ціну \n8) Поповнити карту" );
            int chose =in.nextInt();

            switch (chose){
                case 1:
                    Card card;
                    System.out.println("Обиріть карту :\n1) NumberCard \n2) TimeCard \n3) PreferentialPayCard " +
                            "\n4) UsualPayCArd");
                    int choseCard =in.nextInt();
                    switch (choseCard){
                        case 1:
                            System.out.println("Ведіть кількість поїздок :");
                            int number =in.nextInt();
                            card =register.createNumberCard(number);
                            break;
                        case 2:
                            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

                            System.out.print("Ведіть стартову дату :\n");
                            in.nextLine();
                            String startDate =in.nextLine();


                            System.out.print("Ведіть кінцеву дату :\n");
                            String endDate =in.nextLine();

                            card =register.createTimeCard(format.parse(startDate),format.parse(endDate));
                            break;
                        case 3:
                            System.out.println("Ведіть кількість стартовий баланс карти :");
                            int preferCash =in.nextInt();
                            card =register.createPreferentialPayCard(preferCash);
                            break;
                        case 4:
                            System.out.println("Ведіть кількість стартовий баланс карти :");
                            int usualCash =in.nextInt();
                            card =register.createUsualPayCard(usualCash);
                            break;
                        default:
                            throw new IllegalArgumentException("Такої типу карти неіснує");
                    }
                    break;
                case 2:
                    System.out.println("Ведіть id карти : ");

                    int id =in.nextInt();

                    System.out.println(register.getCardInfo(id));
                    break;
                case 3:
                    System.out.println("Ведіть id карти : ");

                    int lockId =in.nextInt();

                    register.lockCard(lockId);
                    break;
                case 4:
                    System.out.println("Ведіть id карти : ");

                    int unlockId =in.nextInt();

                    register.unlockCard(unlockId);
                    break;
                case 5:
                    System.out.println("Ведіть id карти : ");

                    int passId =in.nextInt();

                    System.out.println(turnstile.pass(passId));
                    break;
                case 6:
                    List<String> list;
                    System.out.println("Виберіть дані які хочете отримати : \n1) дані проходу конкретної картки \n2) дані проходу конкретного типу карток " +
                            "\n3) дані проходу усіх карток ");
                    int choseDate =in.nextInt();

                    switch (choseDate){
                        case 1:
                            System.out.println("Ведіть id карти : ");

                            int DateId =in.nextInt();

                            list = register.getPassageDate(DateId);
                            break;
                        case 2:
                            System.out.println("Обиріть карту :\n1) NumberCard \n2) TimeCard \n3) PreferentialPayCard " +
                                    "\n4) UsualPayCArd");
                            choseCard =in.nextInt();
                            String choseType;

                            switch (choseCard){
                                case 1:
                                    choseType ="NumberCard";
                                    break;
                                case 2:
                                    choseType ="TimeCard";
                                    break;
                                case 3:
                                    choseType ="PreferentialPayCard";
                                    break;
                                case 4:
                                    choseType ="UsualPayCard";
                                    break;
                                default:
                                    throw new IllegalArgumentException("Такої типу карти неіснує");
                            }

                            list =register.getPassageDate(choseType);
                            break;
                        case 3:
                            list = register.getPassageDate();
                            break;
                        default:
                            throw new IllegalArgumentException("Такої функції немає");
                    }

                    for (String row:
                             list) {
                        System.out.println(row);
                    }
                    break;
                case 7:
                    System.out.println("Ведіть нову ціну проходу : ");

                    int newPrice =in.nextInt();
                    Turnstile.setPrice(newPrice);

                    System.out.println(Turnstile.setPrice(newPrice));
                    break;
                case 8:
                    System.out.println("Ведіть id карти : ");

                    int payCardId =in.nextInt();

                    if(!(Register.cards.get(payCardId) instanceof PayCard)){
                        throw new Exception("");
                    }
                    PayCard payCard =(PayCard) Register.cards.get(payCardId);

                    System.out.println("Ведіть суму поповнення : ");

                    double price =in.nextDouble();

                    if(payCard.replenish(price))
                        System.out.println("Карту" +payCard.getId()+ " поповнено на суму : "+ payCard.funds);
                    break;
            }
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        catch (IndexOutOfBoundsException m){
            System.out.println(m.getMessage());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        }
   // }
}
