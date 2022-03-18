import java.util.Scanner;

public class Handler {
    private static User setAttribsToUser(){
        User user = new User();
        Scanner in = new Scanner(System.in);
        double num=0;
        String str="";
        boolean corr;


        corr=false;
        System.out.println("Введите желаемую сумму ипотечного кредита:");
        do{
            str = in.nextLine();
            try{
                num = Double.parseDouble(str);
                if(!user.setMortgageAmount(num))corr=false;
                else corr=true;
            }
            catch (Exception e){
                System.out.println("Введите корректное значение.");
                corr=false;
            }
        }
        while(!corr);

        corr=false;
        System.out.println("Введите желаемую сумму первоначального взноса:");
        do{
            str = in.nextLine();
            try{
                num = Double.parseDouble(str);
                if(!user.setInitialPayment(num))corr=false;
                else corr=true;
            }
            catch (Exception e){
                System.out.println("Введите корректное значение.");
                corr=false;
            }
        }
        while(!corr);

        corr=false;
        System.out.println("Введите ежемесячный доход Вашей семьи:");
        do{
            str = in.nextLine();
            try{
                num = Double.parseDouble(str);
                if(!user.setMonthlyIncome(num))corr=false;
                else corr=true;
            }
            catch (Exception e){
                System.out.println("Введите корректное значение.");
                corr=false;
            }
        }
        while(!corr);

        corr=false;
        int amountOfMembers =0;
        System.out.println("Введите количество членов семьи, включая Вас:");
        do{
            str = in.nextLine();
            try{
                amountOfMembers = Integer.parseInt(str);
                if(!user.setAmountOfFamilyMembers(amountOfMembers))corr=false;
                else corr=true;
            }
            catch (Exception e){
                System.out.println("Введите корректное значение.");
                corr=false;
            }
        }
        while(!corr);

        corr=false;
        System.out.println("Введите количество детей Вашей семьи:");
        do{
            str = in.nextLine();
            try{
                amountOfMembers = Integer.parseInt(str);
                if(!user.setAmountOfChildren(amountOfMembers))corr=false;
                else corr=true;
            }
            catch (Exception e){
                System.out.println("Введите корректное значение.");
                corr=false;
            }
        }
        while(!corr);

        if(user.getAmountOfChildren()!=0){
            corr=false;
            System.out.println("Возраст старшего ребенка в семье ниже 18 лет? (Да/Нет)");
            do{
                str = in.nextLine();
                try{
                    if(str.equalsIgnoreCase("Да")){
                        user.setChildrenUnder18Years(true);
                        corr=true;
                    }
                    else if (str.equalsIgnoreCase("Нет")){
                        user.setChildrenUnder18Years(false);
                        corr=true;
                    }
                    else {
                        throw new IllegalArgumentException("Illegal value of isChildrenUnder18Years");
                    }
                }
                catch (Exception e){
                    System.out.println("Введите корректное значение.");
                    corr=false;
                }
            }
            while(!corr);
        }

        in.close();
        return user;
    }

    public static void startUserCheckForMortgage(){
        User user = setAttribsToUser();
        Mortgage mortgage = new Mortgage(user);
        mortgage.setAttribs();
        System.out.println(mortgage);
    }
}
