import model.Company;
import model.Individual;
import model.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i=1; i<=n ; i++){
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c): ");
            char type = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Anual income: ");
            Double anualIncome = sc.nextDouble();
            if (type == 'c'){
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                list.add(new Company(name, anualIncome, numberOfEmployees));
            }else if (type == 'i'){
                System.out.print("Health expenditures: ");
                Double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name, anualIncome, healthExpenditures));
            }
            }
            System.out.println("TAXES PAID: ");
            for(TaxPayer tp : list){
                System.out.println(tp.getName() + ": $ " + String.format("%.2f", tp.tax()));
            }

            double sum=0.0;
            for(TaxPayer tp:list){
                sum +=tp.tax();
            }
        System.out.println("TOTAL TAXES: $  " + String.format("%.2f", sum));

        sc.close();
    }
}