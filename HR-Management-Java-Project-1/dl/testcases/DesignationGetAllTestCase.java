import com.ami.tech.hr.dl.exceptions.*;
import com.ami.tech.hr.dl.interfaces.dto.*;
import com.ami.tech.hr.dl.interfaces.dao.*;
import com.ami.tech.hr.dl.dto.*;
import com.ami.tech.hr.dl.dao.*;
import java.util.*;
public class DesignationGetAllTestCase{
    public static void main(String[] args) {
        
        try{
        
        DesignationDAOInterface designationDAO;	    
	designationDAO=new DesignationDAO();
	Set<DesignationDTOInterface> designations=designationDAO.getAll();

    designations.forEach((designationDTO)->{
        System.out.printf("Code: %d, Title: %s\n ",designationDTO.getCode(), designationDTO.getTitle());	   
    });
     
          

        }catch(DAOException daoException)
        {
            System.out.println(daoException.getMessage());
        }
    }
}