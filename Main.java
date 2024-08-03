package jdbcloginpage;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
public class Main {
	public static void main(String args[])
	{
		UserDao userdao=new UserDao();
		Scanner sc=new Scanner(System.in);
		boolean exit=false;
		while(!exit)
		{
			System.out.println("Login Details");
            System.out.println("1. Add User");
            System.out.println("2. Update User");
            System.out.println("3. Delete User");
            System.out.println("4. Display User");
            System.out.println("5. Display All Users");
            System.out.println("6. Exit");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
            	case 1:
            		try
            		{
            			User user=new User();
                        System.out.print("Enter name: ");
                        user.setname(sc.nextLine());
                        System.out.print("Enter email: ");
                        user.setemail(sc.nextLine());
                        System.out.print("Enter username: ");
                        user.setusername(sc.nextLine());
                        System.out.print("Enter password: ");
                        user.setpassword(sc.nextLine());
                        user.setLastLogin(new Timestamp(System.currentTimeMillis()));
                        userdao.adduser(user);
                        System.out.println("User added.");

            			
            		} catch(SQLException e)
            		{
            			e.printStackTrace();
            		}
            		break;
            	case 2:
            		try
            		{
            			System.out.println("Enter user ID to update");
            			int id1=sc.nextInt();
            			sc.nextLine();
            			User ut = userdao.getuser(id1);
            			if(ut!=null)
            			{
            				System.out.println("Enter new name:");
            				ut.setname(sc.nextLine());
            				System.out.println("Enter new email:");
            				ut.setemail(sc.nextLine());
                            System.out.print("Enter new username: ");
                            ut.setusername(sc.nextLine());
                            System.out.print("Enter new password: ");
                            ut.setpassword(sc.nextLine());
                            ut.setLastLogin(new Timestamp(System.currentTimeMillis()));
                            userdao.updateUser(ut);
                            System.out.println("User updated.");

            			}
            			else
            			{
            				System.out.println("User not found");
            			}
            		}
            		catch(SQLException e)
            		{
            			e.printStackTrace();
            		}
            		break;
            	case 3:
            		try
            		{
            			System.out.print("Enter user ID to delete:");
            			int id=sc.nextInt();
            			userdao.deleteuser(id);
            			System.out.println("User Deleted");
            		}
            		catch(SQLException e)
            		{
            			e.printStackTrace();
            		}
            		break;
            	case 4:
            		try
            		{
            			System.out.print("Enter user ID to display:");
            			int id=sc.nextInt();
            			User ru=userdao.getuser(id);
            			if(ru!=null)
            			{
            				System.out.println("Retrieved User:"+ ru.getname()+", "+ru.getemail()+","+ru.getusername()+","+ru.getpassword()+",Last Login"+ ru.getlastlogin());
    
            			}
            			else
            			{
            				System.out.println("User not found");
            			}
            		}
            		catch(SQLException e)
            		{
            			e.printStackTrace();
            		}
            		break;
            	case 5:
            		try
            		{
            			List<User> users = userdao.getAllUsers();
            			System.out.println("All Users:");
            			for(User u:users)
            			{
            				System.out.println(u.getid()+": "+u.getname()+"- "+u.getemail()+"- "+u.getusername()+
            						"- "+u.getpassword()+"- Last Login:"+u.getlastlogin());
            			}
            		}
            		catch(SQLException e)
            		{
            			e.printStackTrace();
            		}
            		break;
            	case 6:
            		exit=true;
            		break;
            	default:
            		System.out.println("Invalid choice. Please try again.");
            }
		
		}
		sc.close();
	
	}

}
