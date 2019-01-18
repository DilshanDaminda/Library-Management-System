package lk.ijse.dep.library.dao;

import lk.ijse.dep.library.dao.custom.impl.*;

public class DAOFactory {

     private static DAOFactory daoFactory;

     public enum DAOTypes{
         BOOK,BORROW,MEMBER,PUBLISHER,QUERY,RETURNBOOK;
     }
       private DAOFactory(){}

       public static DAOFactory getInstance(){
         if(daoFactory== null){

             daoFactory = new DAOFactory();
         }
         return daoFactory;
       }

       public <T extends SuperDAO> T getDAO (DAOTypes daoTypes){
         switch (daoTypes)
         {
             case BOOK:
                 return (T) new BookDAOImpl();

             case BORROW:
                 return (T)  new BorrowDAOImpl();
             case MEMBER:
                 return (T) new MemberDAOImpl();
             case RETURNBOOK:
                 return (T) new RreturnbookDAOImpl();
             case QUERY:
                 return (T) new QueryDAOImpl();
             case PUBLISHER:
                 return (T) new PublisherDAOImpl();
               default:
                   return null;
         }


       }
}
