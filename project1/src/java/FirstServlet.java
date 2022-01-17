import java.io.FileReader;
import java.io.FileWriter;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;

//@WebServlet(urlPatterns = {"/firstLogin"})
public class FirstServlet implements Servlet{
    
    ServletConfig conf;
    
    public  String[] getDataMysql(String RollNo,String pass) throws Exception{
        String ans[]={"",""};
        String username = "root";
        String password = "";
        String driverclassname = "com.mysql.cj.jdbc.Driver";
        String jdbcurl="jdbc:mysql://localhost:3306/testingschemas?zeroDateTimeBehavior=CONVERT_TO_NULL"; 
        String tableName = "servlettest";
        
        Class.forName(driverclassname);

        Connection Con = DriverManager.getConnection(jdbcurl, username, password);
        //System.out.println("Connection Created"); 
        Statement st = Con.createStatement();
        String query = "SELECT * FROM "+tableName+" where RollNo like '"+RollNo+"'";
        
        ResultSet rs = st.executeQuery(query);
        /*while(rs.next()){
            System.out.println(rs.getString(1)+"--->"+rs.getString(2)+"--->"+rs.getString(3)+"--->"+rs.getString(4));
        }*/
        if(rs.next()){
            ans[0] = rs.getString(1);
            ans[1] = rs.getString(2);
        }
        else{
            System.out.println("Record isn't present");
        }
        Con.close();
       
        return ans;
    }
    @Override
    public void init(ServletConfig config)  {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        
        this.conf = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        FileReader fr = new FileReader("C:\\Users\\lenovo\\OneDrive\\Documents\\NetBeansProjects\\"
                + "Electricity-Billing-System-master\\Electricity-Billing-System\\src\\file.txt");

        int i;
        String st="";
        while ((i=fr.read()) != -1)
          st=st+(char)i;
        
        fr.close();
        //System.out.println(st); 
        st = st.trim();
        String arr[]={"","",""};
        int j=0; String ss = "";
        for(i=0;i<st.length();i++){
            if(st.charAt(i)==','){
                arr[j]=ss;
                ss="";
                j++;
            }
            else ss+=st.charAt(i);
        }
        PrintWriter out = res.getWriter();
        arr[j]=ss;
        //System.out.println(arr[0]+"DD"+arr[1]+"DD"+arr[2]);
        if(arr[0].equals("Not")){
            String cvv = req.getParameter("cvv");
            String chk = "111";
            String name = req.getParameter("name");
            String debitNumber = req.getParameter("debitNumber");
            
            boolean flag = true;
            for(int ii=0;ii< debitNumber.length();ii++){
                if(debitNumber.charAt(ii)<'0' || debitNumber.charAt(ii)>'9' ) flag = false;
            }
            if(debitNumber.length()!=16) flag = false;
            if(cvv.equals(chk) && flag){
                try{
                    String username = "root";
                    String password = "";
                    String driverclassname = "com.mysql.cj.jdbc.Driver";
                    String jdbcurl="jdbc:mysql://localhost:3306/ebs?zeroDateTimeBehavior=CONVERT_TO_NULL"; 

                    Class.forName(driverclassname);

                    Connection Con = DriverManager.getConnection(jdbcurl, username, password);
                    //System.out.println("Connection Created"); 
                    Statement stmt = Con.createStatement();
                    stmt.executeUpdate("update bill set status = 'Paid' where meter = "+arr[1]+" AND month = '"+arr[2]+"'");
                    out.println("<center><h1> Payment Successfull </h1>"
                            + "<h3> Now you can go to frame </h3></center>");
                    
                    arr[0]="Yes";
                    st = arr[0]+","+arr[1]+","+arr[2];
                                        
                        FileWriter myWriter = new FileWriter("C:\\Users\\lenovo\\OneDrive\\Documents\\NetBeansProjects\\"
                + "Electricity-Billing-System-master\\Electricity-Billing-System\\src\\file.txt");
                        myWriter.write(st);
                        myWriter.close();
                    
//                    RequestDispatcher rd = req.getRequestDispatcher("servlett");
//                    rd.include(req, res);
                }
                catch (Exception eee){
                    System.out.println("Exception : "+ eee);
                }
            }
            else{
                out.println("<center><h1> Payment Unsuccessful </h1>"
                            + "<h3> Please Enter Correct Details </h3></center>");
                RequestDispatcher rd = req.getRequestDispatcher("payment.jsp");
                    rd.include(req, res);
            } 
        }
        else out.println("<center><h1> You have no due bills to pay in selected month</h1> </center>");
    }

    @Override
    public String getServletInfo() {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        return "My servlet's information";
    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Destroying");
    }
    
}
