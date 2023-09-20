import com.ami.tech.hr.dl.exceptions.*;

import com.ami.tech.hr.dl.interfaces.dao.*;

import com.ami.tech.hr.dl.dao.*;
public class DesignationGetCountTestCase{
    public static void main(String[] args) {

        try{
            DesignationDAOInterface designationDAO;
            designationDAO=new DesignationDAO();
         
            System.out.println("Designation Count: "+ designationDAO.getCount());

             

        }catch(DAOException daoException)
        {
            System.out.println(daoException.getMessage());
        }
    }
}