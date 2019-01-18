package lk.ijse.dep.library.business;

import lk.ijse.dep.library.business.costom.impl.BookManageBOImpl;
import lk.ijse.dep.library.business.costom.impl.BorrowManageBOImpl;
import lk.ijse.dep.library.business.costom.impl.MemberManageBOImpl;
import lk.ijse.dep.library.business.costom.impl.ReturnManageBOImpl;
import lk.ijse.dep.library.dao.custom.impl.MemberDAOImpl;

public class BOFactory {


    public enum BOTypes{
        BOOK_MANAGE,MEMBER_MANAGE,BORROW_MANAGE,RETURN_MANAGE

    }
    private static BOFactory boFactory;


    public BOFactory() {
    }

    public static BOFactory getInstance(){
        if(boFactory == null){

            boFactory =new BOFactory();
        }
        return boFactory;

    }

    public <T extends SuperBO> T getBO(BOTypes boTypes) {
        switch (boTypes) {
            case BOOK_MANAGE:
                return (T) new BookManageBOImpl();
            case MEMBER_MANAGE:
                return (T) new MemberManageBOImpl();
            case BORROW_MANAGE:
                return (T) new BorrowManageBOImpl();
            case RETURN_MANAGE:
                return (T) new ReturnManageBOImpl();

                default:
                    return null;


        }


    }

}
