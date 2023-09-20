import com.ami.tech.hr.dl.exceptions.*;
import com.ami.tech.hr.dl.interfaces.dto.*;
import com.ami.tech.hr.dl.interfaces.dao.*;
import com.ami.tech.hr.dl.dto.*;
import com.ami.tech.hr.dl.dao.*;
public class DesignationAddTestCase{
    public static void main(String[] args) {
        String title=args[0];
        try{
            DesignationDTOInterface designationDTO;
            designationDTO =new DesignationDTO();
            designationDTO.setTitle(title);
            DesignationDAOInterface designationDAO;
            designationDAO=new DesignationDAO();
            designationDAO.add(designationDTO);
            System.out.println("Designation: "+title+"added with code as: "+designationDTO.getCode());

             

        }catch(DAOException daoException)
        {
            System.out.println(daoException.getMessage());
        }
    }
}