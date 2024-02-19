import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;

class Contact{
    public  Connection con;
    Statement st;
  

    public boolean addContact(String name,String ph_no, String email) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/contact_management", "root", "Ankit@123");
            st=con.createStatement();
            // ps.setString(2, name);
            // ps.setString(3, ph_no);
            // ps.setString(4, email);
            String sql="insert into contacts(name,phone_no,email) values('"+name+"','"+ph_no+"','"+email+"')";
            int result=st.executeUpdate(sql);
            if(result !=0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
       return false;
    }

    public boolean UpdateContact(int id,String name,String ph_no,String email){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/contact_management", "root", "Ankit@123");
            st=con.createStatement();
            // ps.setString(2, name);
            // ps.setString(3, ph_no);
            // ps.setString(4, email);
            String sql="update contacts set name='"+name+"',phone_no='"+ph_no+"',email='"+email+"' where id='"+id+"' ";
            int result=st.executeUpdate(sql);
            if(result !=0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteContact(int id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/contact_management", "root", "Ankit@123");
            st=con.createStatement();
            // ps.setString(2, name);
            // ps.setString(3, ph_no);
            // ps.setString(4, email);
            String sql="delete from contacts where id='"+id+"' ";
            int result=st.executeUpdate(sql);
            if(result !=0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }


    public static void main(String cp[]){
        Contact contact=new Contact();
        Scanner sc=new Scanner(System.in);

        while(true){
                System.out.println("Select Option From Following Menu:- "
               +" \n 1.Add New Contact"
               +" \n 2.Update Contact"
               +" \n 3.View Contact"
               +" \n 4.Delete Contact"
               +" \n 5.Exit"
                );

                System.out.println("Select Option From Above");
                int n=sc.nextInt();


                if(n==1){
                    String name,ph_no,email;
                    System.out.println("Enter Name:- ");
                    name = sc.next();
                    if(name.length() < 3){
                        System.out.println("Name Length Should Be More The 3");
                        System.out.println("----------------------------------------------");
                        System.out.println("----------------------------------------------");
                        continue;
                    }


                    System.out.println("Enter Phone No.");
                    ph_no = sc.next();
                    if(ph_no.length() != 10){
                        System.out.println("Mobile Length Should Be  10 digit");
                        System.out.println("----------------------------------------------");
                        System.out.println("----------------------------------------------");
                        continue;
                    }


                    System.out.println("Enter Email");
                    email = sc.next();
                    String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
                    Pattern p=Pattern.compile(regex);
                    if(p.matcher(email).matches() == false ||  email == null){
                        System.out.println("Email should not be null or it must be in valid format ");
                        System.out.println("----------------------------------------------");
                        System.out.println("----------------------------------------------");
                        continue;
                    }
                    boolean result = contact.addContact(name,ph_no,email);
                    if(result ==true){
                        System.out.println("Record Inserted");
                        System.out.println("----------------------------------------------");
                        System.out.println("----------------------------------------------");
                        continue;
                    }
                    else{
                        System.out.println("Failed Add Record");
                        System.out.println("----------------------------------------------");
                        System.out.println("----------------------------------------------");
                        continue;
                    }


                }
                else if(n==2){
                    String name,ph_no,email;
                    int id;

                    System.out.println("Enter Id:- ");
                    id = sc.nextInt();
                    if(id <= 0){
                        System.out.println("Id should be greater than 0");
                        System.out.println("----------------------------------------------");
                        System.out.println("----------------------------------------------");
                        continue;
                    }


                    System.out.println("Enter Name:- ");
                    name = sc.next();
                    if(name.length() < 3){
                        System.out.println("Name Length Should Be More The 3");
                        System.out.println("----------------------------------------------");
                        System.out.println("----------------------------------------------");
                        continue;
                    }


                    System.out.println("Enter Phone No.");
                    ph_no = sc.next();
                    if(ph_no.length() != 10){
                        System.out.println("Mobile Length Should Be  10 digit");
                        System.out.println("----------------------------------------------");
                        System.out.println("----------------------------------------------");
                        continue;
                    }


                    System.out.println("Enter Email");
                    email = sc.next();
                    String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
                    Pattern p=Pattern.compile(regex);
                    if(p.matcher(email).matches() == false ||  email == null){
                        System.out.println("Email should not be null or it must be in valid format ");
                        System.out.println("----------------------------------------------");
                        System.out.println("----------------------------------------------");
                        continue;
                    }
                    boolean result = contact.UpdateContact(id,name,ph_no,email);
                    if(result ==true){
                        System.out.println("Record Updated");
                        System.out.println("----------------------------------------------");
                        System.out.println("----------------------------------------------");
                        continue;
                    }
                    else{
                        System.out.println("Failed Update Record");
                        System.out.println("----------------------------------------------");
                        System.out.println("----------------------------------------------");
                        continue;
                    }


                }
                else if(n==3){
                    try {
                       
                        Class.forName("com.mysql.cj.jdbc.Driver");
                       Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/contact_management", "root", "Ankit@123");
                       Statement st=con.createStatement();
                       ResultSet rs=st.executeQuery("select * from contacts");
                       System.out.println("----------------------------------------------");
                        System.out.println("----------------------------------------------");
                        if(rs == null){
                            System.out.println("NO CONTACTS");
                        }
                        else{
                            System.out.println("ID \t NAME \t PHONE NO. \t EMAIL");
                             while(rs.next()){
                                    System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
                            }

                            System.out.println("----------------------------------------------");
                            System.out.println("----------------------------------------------");
                    }
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    
                }
                else if(n==4){
                    int id;

                    System.out.println("Enter Id to Delete Contact:- ");
                    id = sc.nextInt();
                    if(id <= 0){
                        System.out.println("Id should be greater than 0");
                        System.out.println("----------------------------------------------");
                        System.out.println("----------------------------------------------");
                        continue;
                    }
                    else{
                       boolean result= contact.deleteContact(id);
                       if(result ==true){
                        System.out.println("Record Deleted");
                        System.out.println("----------------------------------------------");
                        System.out.println("----------------------------------------------");
                        continue;
                    }
                    else{
                        System.out.println("Failed Delete Record");
                        System.out.println("----------------------------------------------");
                        System.out.println("----------------------------------------------");
                        continue;
                    }
                    }
                    
                }
                else if(n==5){
                    break;
                }
                else{
                    System.out.println("Select Valid Option");
                }
        }
    }
}