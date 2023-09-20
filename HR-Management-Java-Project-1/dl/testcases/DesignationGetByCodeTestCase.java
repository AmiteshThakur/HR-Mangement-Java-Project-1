import com.ami.tech.hr.dl.exceptions.*;
import com.ami.tech.hr.dl.interfaces.dto.*;
import com.ami.tech.hr.dl.interfaces.dao.*;
import com.ami.tech.hr.dl.dto.*;
import com.ami.tech.hr.dl.dao.*;
public class DesignationGetByCodeTestCase{
    public static void main(String[] args) {
        int code=Integer.parseInt(args[0]);
        try{
        DesignationDTOInterface designationDTO;
        DesignationDAOInterface designationDAO;	    
	designationDAO=new DesignationDAO();
	designationDTO= designationDAO.getByCode(code);
	System.out.printf("Code: %d, Title: %s\n ",designationDTO.getCode(), designationDTO.getTitle());	
		

	

            

        }catch(DAOException daoException)
        {
            System.out.println(daoException.getMessage());
        }
    }
}