import com.ami.tech.hr.dl.exceptions.*;
import com.ami.tech.hr.dl.interfaces.dto.*;
import com.ami.tech.hr.dl.interfaces.dao.*;
import com.ami.tech.hr.dl.dto.*;
import com.ami.tech.hr.dl.dao.*;
public class DesignationTitleExistsTestCase{
    public static void main(String[] args) {
        
	String title=args[0];
        title=title.trim();
	try{
        
        DesignationDAOInterface designationDAO;	    
	designationDAO=new DesignationDAO();
	boolean answer =designationDAO.titleExists(title);
	if(answer==true)System.out.println("Title: "+title+" exists");
	else System.out.println("Title: "+title+" not exists.");	

	

            

        }catch(DAOException daoException)
        {
            System.out.println(daoException.getMessage());
        }
    }
}