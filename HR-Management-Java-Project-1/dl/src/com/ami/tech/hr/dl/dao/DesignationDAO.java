 package com.ami.tech.hr.dl.dao;

import com.ami.tech.hr.dl.exceptions.*;
import com.ami.tech.hr.dl.interfaces.dao.*;
import com.ami.tech.hr.dl.interfaces.dto.*;
import java.io.*;
import java.util.*;

public class DesignationDAO implements DesignationDAOInterface {

  private static final String FILE_NAME = "designation.data";

  public void add(DesignationDTOInterface designationDTO) throws DAOException {
    if (designationDTO == null) throw new DAOException("Designation is nulll");
    String title = designationDTO.getTitle();
    if (title == null) throw new DAOException("Designation in null");
    title = title.trim();
    if (title.length() == 0) throw new DAOException(
      "Length of designation is zero"
    );
    try {
      File file = new File(FILE_NAME);
      RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
      int lastGeneratedCode = 0;
      int recordCount = 0;
      String lastGeneratedCodeString = "";
      String recordCountString = "";
      if (randomAccessFile.length() == 0) {
        lastGeneratedCodeString = "0";
        while (lastGeneratedCodeString.length() < 10) lastGeneratedCodeString +=
          " ";
        recordCountString = "0";
        while (recordCountString.length() < 10) recordCountString += " ";
        randomAccessFile.writeBytes(lastGeneratedCodeString);
        randomAccessFile.writeBytes("\n");
        randomAccessFile.writeBytes(recordCountString);
        randomAccessFile.writeBytes("\n");
      } else {
        lastGeneratedCodeString = randomAccessFile.readLine().trim();
        recordCountString = randomAccessFile.readLine().trim();
        lastGeneratedCode = Integer.parseInt(lastGeneratedCodeString);
        recordCount = Integer.parseInt(recordCountString);
      }
      int fCode;
      String fTitle;
      while (randomAccessFile.getFilePointer() < randomAccessFile.length()) {
        fCode = Integer.parseInt(randomAccessFile.readLine());
        fTitle = randomAccessFile.readLine();
        if (fTitle.equalsIgnoreCase(title)) {
          randomAccessFile.close();
          throw new DAOException("Designation: " + title + " exists.");
        }
        int code = lastGeneratedCode + 1;
        randomAccessFile.writeBytes(String.valueOf(code));
        randomAccessFile.writeBytes("\n");
        randomAccessFile.writeBytes(title);
        randomAccessFile.writeBytes("\n");
        designationDTO.setCode(code);
        // randomAccessFile.seek(0);
        lastGeneratedCode++;
        recordCount++;
        lastGeneratedCodeString = String.valueOf(lastGeneratedCode);
        while (lastGeneratedCodeString.length() < 10) lastGeneratedCodeString =
          " ";
        recordCountString = String.valueOf(recordCount);
        while (recordCountString.length() < 10) recordCountString += " ";
        randomAccessFile.seek(0);
        randomAccessFile.writeBytes(lastGeneratedCodeString);
        randomAccessFile.writeBytes("\n");
        randomAccessFile.writeBytes(recordCountString);
        randomAccessFile.writeBytes("\n");
        randomAccessFile.close();
      }
    } catch (IOException ioException) {
      throw new DAOException(ioException.getMessage());
    }
    // throw new DAOException("Not yet implemented");
    //
  }

  public void update(DesignationDTOInterface designationDTO)
    throws DAOException {
    throw new DAOException("Not yet implemented");
  }

  public void delete(int code) throws DAOException {
    throw new DAOException("Not yet implemented");
  }

  public TreeSet<DesignationDTOInterface> getAll() throws DAOException {
    throw new DAOException("Not yet implemented");
  }

  public DesignationDTOInterface getByCode(int code) throws DAOException {
    throw new DAOException("Not yet implemented");
  }

  public DesignationDTOInterface getByTitle(String title) throws DAOException {
    throw new DAOException("Not yet implemented");
  }

  public boolean codeExists(int code) throws DAOException {
    throw new DAOException("Not yet implemented");
  }

  public boolean titleExists(String title) throws DAOException {
    throw new DAOException("Not yet implemented");
  }

  public int getCount() throws DAOException {
    throw new DAOException("Not yet implemented");
  }
}
