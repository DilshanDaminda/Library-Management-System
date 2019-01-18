package lk.ijse.dep.library.business.costom.impl;

import lk.ijse.dep.library.business.Converter;
import lk.ijse.dep.library.business.costom.MemberManageBO;
import lk.ijse.dep.library.dao.DAOFactory;
import lk.ijse.dep.library.dao.custom.MemberDAO;
import lk.ijse.dep.library.dao.custom.impl.MemberDAOImpl;
import lk.ijse.dep.library.dto.BookDTO;
import lk.ijse.dep.library.dto.MemberDTO;

import java.sql.SQLException;
import java.util.List;


public class MemberManageBOImpl implements MemberManageBO {

   private MemberDAO memberDAO;

    public MemberManageBOImpl(){
        memberDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MEMBER);
    }

    @Override
    public List<MemberDTO> getMember() throws Exception {
       return memberDAO.findAll().map(Converter::<MemberDTO> getDTOList).get();
    }

    @Override
    public boolean createMember(MemberDTO dto) throws Exception {
        return memberDAO.save(Converter.getEntity(dto));
    }

    @Override
    public boolean updateMember(MemberDTO dto) throws Exception {
        return memberDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteMember(String memberID) throws SQLException, Exception {
        return memberDAO.delete(memberID);
    }

    @Override
    public MemberDTO findMember(String id) throws SQLException, Exception {
        return memberDAO.find(id).map(Converter::<MemberDTO>getDTO).orElse(null);
    }
}


