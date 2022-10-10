package database;
import java.sql.*;
import java.util.Scanner;
public class ExpenseTracker {
    static final String DB_URL = "jdbc:mysql://localhost:3306/exp";
    static final String USER = "root";
    static final String PASS = "root";

    public void insertData() throws Exception {
        String expensesName;
        int expensesAmount;
        String expensesDate;
        String expensesCategory;
        String paymentMode;
        Scanner sc = new Scanner(System.in);
        try (Statement stmt = getConnection().createStatement()) {
            System.out.println("Enter Expenses Name : ");
            expensesName = sc.next();
            System.out.println("Enter Expenses Amount : ");
            expensesAmount = sc.nextInt();
            System.out.println("Enter Expenses Date : ");
            expensesDate = sc.next();
            System.out.println("Enter Expenses categery : ");
            expensesCategory = sc.next();
            System.out.println("Enter Payment Mode : ");
            paymentMode = sc.next();
            String insertQuery = "INSERT INTO expense(Expense_Name,Expense_Amount,Expense_Date,Expense_Category,Payment_Mode) values('" + expensesName + "'," + expensesAmount + ",'" + expensesDate + "','" + expensesCategory + "','" + paymentMode + "');";
            stmt.executeUpdate(insertQuery);
            System.out.println("Records inserted successfully!!!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Connection getConnection() throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        return conn;
    }

    public void expenseName() throws Exception {
        String eName = "select Expense_Name from expense";
        Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(eName);
        while (rs.next()) {
            System.out.println("Expense Name : " + rs.getString("Expense_Name"));
        }
    }

    public void expenseAmount() throws Exception {
        String eAmount = "select Expense_Amount from expense";
        Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(eAmount);
        while (rs.next()) {
            System.out.println("Expense Amount : " + rs.getInt("Expense_Amount"));
        }
    }

    public void expenseDate() throws Exception {
        String eDate = "select Expense_Date from expense";
        Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(eDate);
        while (rs.next()) {
            System.out.println("Expense Date : " + rs.getString("Expense_Date"));
        }
    }

    public void expenseCategory() throws Exception {
        String eCategory = "select Expense_Category from expense";
        Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(eCategory);
        while (rs.next()) {
            System.out.println("Expense Category : " + rs.getString("Expense_Category"));
        }
    }

    public void paymentMode() throws Exception {
        String pMode = "select Payment_Mode from expense";
        Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(pMode);
        while (rs.next()) {
            System.out.println("Payment Mode : " + rs.getString("Payment_Mode"));
        }
    }

    public void allRecord() throws Exception {
        String record = "select * from expense";
        Statement stmt = getConnection().createStatement();
        ResultSet rt = stmt.executeQuery(record);
        System.out.println("Expense Name\tExpense Amount\tExpense Date\tExpense Category\tPayment Mode");
        while (rt.next()) {
            System.out.println(rt.getString("Expense_Name") + "\t\t\t\t" + rt.getInt("Expense_Amount") + "\t\t\t\t" + rt.getString("Expense_Date") + "\t\t" + rt.getString("Expense_Category") + "\t\t" + rt.getString("Payment_Mode"));
        }
    }

    public void deleteRecord() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Expense Name For delete The Query");
        String deleteQuery = sc.next();
        String deleteStatement = "delete from expense where Expense_Name='" + deleteQuery + "';";
        Statement stmt = getConnection().createStatement();
        stmt.executeUpdate(deleteStatement);
        System.out.println("Delete  Successfully !");
    }

    public void updateName() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter New Name For Update The Expense Name : ");
        String newQuery = sc.next();
        System.out.println("Please Enter Existing Expense Name : ");
        String existingQuery = sc.next();
        String updateName = "update expense set Expense_Name='" + newQuery + "' where Expense_Name='" + existingQuery + "';";
        Statement stmt = getConnection().createStatement();
        stmt.executeUpdate(updateName);
        System.out.println("Expense Name Updated Successfully !!! ");
    }

    public void updateAll() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter New Expense Name : ");
        String eName = sc.next();
        System.out.println("Enter new Amount : ");
        int eAmount = sc.nextInt();
        System.out.println("Enter New Expense Date : ");
        String eDate = sc.next();
        System.out.println("Enter Expense Category : ");
        String eCategory = sc.next();
        System.out.println("Enter Payment Mode : ");
        String pMode = sc.next();
        System.out.println("Enter Existing Expense Name :");
        String exName = sc.next();
        String updateQuery = "update expense set Expense_Name='" + eName + "',Expense_Amount=" + eAmount + ",Expense_Date='" + eDate + "',Expense_Category='" + eCategory + "',Payment_Mode='" + pMode + "' where Expense_Name='" + exName + "';";
        Statement stmt = getConnection().createStatement();
        stmt.executeUpdate(updateQuery);
        System.out.println("All Records Updated Successfully !!!");
    }

    public void updateAmount() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter New Amount :");
        int newAmount = sc.nextInt();
        System.out.println("Enter Existing Expense Name : ");
        String eName = sc.next();
        String updateQuery = "update expense set Expense_Amount =" + newAmount + " where Expense_Name ='" + eName + "';";
        Statement stmt = getConnection().createStatement();
        stmt.executeUpdate(updateQuery);
        System.out.println("Expense Amount Updated Successfully !!! ");
    }

    public void updateDate() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter New Date : ");
        String eDate = sc.next();
        System.out.println("Enter Existing Expense Name : ");
        String eName = sc.next();
        String updateQuery = "update expense set Expense_Date ='" + eDate + "' where Expense_Name='" + eName + "';";
        Statement stmt = getConnection().createStatement();
        stmt.executeUpdate(updateQuery);
        System.out.println("Expense Date Updated Successfully !!! ");
    }

    public void updateCategory() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter New Expense Category : ");
        String eCategory = sc.next();
        System.out.println("Enter Existing Expense Name : ");
        String eName = sc.next();
        String updateQuery = "update expense set Expense_Category='" + eCategory + "' where Expense_Name ='" + eName + "';";
        Statement stmt = getConnection().createStatement();
        stmt.executeUpdate(updateQuery);
        System.out.println("Expense Category Updated Successfully !!! ");
    }

    public void updatePayment() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter New Expense Payment Mode : ");
        String pMode = sc.next();
        System.out.println("Enter Existing Expense Name : ");
        String eName = sc.next();
        String updateQuery = "update expense set Payment_Mode ='" + pMode + "' where Expense_Name='" + eName + "';";
        Statement stmt = getConnection().createStatement();
        stmt.executeUpdate(updateQuery);
        System.out.println("Expense Payment Mode Updated Successfully !!! ");
    }

    public static void main(String[] args) throws Exception {


        System.out.println("          *****       ");
        System.out.println("   *** Enter Your Choice *** ");
        System.out.println(" 1.For Insert Data In Database : ");
        System.out.println(" 2.For View The Expense Name : ");
        System.out.println(" 3.For View The Expense Amount ");
        System.out.println(" 4.For View The Expense Date : ");
        System.out.println(" 5.For View The Expense Category : ");
        System.out.println(" 6.For View The Payment Mode : ");
        System.out.println(" 7.For View The All Records : ");
        System.out.println(" 8.For Delete The Query : ");
        System.out.println(" 9.For Update The All Records : ");
        System.out.println(" 10.For Update The Expense Name : ");
        System.out.println(" 11.For update The Expense Amount : ");
        System.out.println(" 12.For Update The Expense Date : ");
        System.out.println(" 13.For Update The Expense Category : ");
        System.out.println(" 14.For Update The Expense Payment Mode :");


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ExpenseTracker obj = new ExpenseTracker();
        switch (n) {
            case 1:
                obj.insertData();
                break;
            case 2:
                obj.expenseName();
                break;
            case 3:
                obj.expenseAmount();
                break;
            case 4:
                obj.expenseDate();
                break;
            case 5:
                obj.expenseCategory();
                break;
            case 6:
                obj.paymentMode();
                break;
            case 7:
                obj.allRecord();
                break;
            case 8:
                obj.deleteRecord();
                break;
            case 9:
                obj.updateAll();
                break;
            case 10:
                obj.updateName();
                break;
            case 11:
                obj.updateAmount();
                break;
            case 12:
                obj.updateDate();
                break;
            case 13:
                obj.updateCategory();
                break;
            case 14:
                obj.updatePayment();
            default:
                System.out.println("Please Enter Correct Number : ");
        }
    }
}
