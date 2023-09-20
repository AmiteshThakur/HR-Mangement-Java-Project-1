import com.ami.tech.hr.dl.exceptions.*;
import com.ami.tech.hr.dl.interfaces.dto.*;
import com.ami.tech.hr.dl.interfaces.dao.*;
import com.ami.tech.hr.dl.dto.*;
import com.ami.tech.hr.dl.dao.*;
public class DesignationCodeExistsTestCase{
    public static void main(String[] args) {
        int code=Integer.parseInt(args[0]);
        try{
        
        DesignationDAOInterface designationDAO;	    
	designationDAO=new DesignationDAO();
	boolean answer =designationDAO.codeExists(code);
	if(answer==true)System.out.println("Code: "+code+" exists");
	else System.out.println("Code: "+code+" not exists.");	

	

            

        }catch(DAOException daoException)
        {
            System.out.println(daoException.getMessage());
        }
    }
}