package lk.ijse.dep.library.business;

import lk.ijse.dep.library.dto.BookDTO;
import lk.ijse.dep.library.dto.MemberDTO;
import lk.ijse.dep.library.dto.SuperDTO;
import lk.ijse.dep.library.entity.Book;
import lk.ijse.dep.library.entity.Member;
import lk.ijse.dep.library.entity.SuperEntity;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static <T extends SuperDTO> T getDTO(SuperEntity entity) {
        if (entity instanceof Member) {
            Member c = (Member) entity;
            return (T) new MemberDTO(c.getMemberid(), c.getMember_name(), c.getMembertype(), c.getMemberdate());

        } else if (entity instanceof Book) {
            Book b = (Book) entity;
            return (T) new BookDTO(b.getBookid(), b.getTitle(), b.getAuthor(), b.getPubid(), b.getAvailability());
        } else {
            throw new RuntimeException("This entity cant be convert to DTO");
        }
    }


    public static <T extends SuperEntity> T getEntity(SuperDTO dto) {
        if (dto instanceof MemberDTO) {
            MemberDTO m = (MemberDTO) dto;
            return (T) new Member(m.getMemberid(), m.getMember_name(), m.getMembertype(), m.getMemberdate());
        } else if (dto instanceof BookDTO) {
            BookDTO b = (BookDTO) dto;

            return (T) new Book(b.getBookid(), b.getTitle(), b.getAuthor(), b.getPubid(), b.getAvailability());
        } else {
            throw new RuntimeException("This is cant be convert entity");

        }
    }


    public static <T extends SuperDTO> List<T> getDTOList(List<? extends SuperEntity> entities) {
        return entities.stream().map(Converter::<T>getDTO).collect(Collectors.toList());
    }

    public static <T extends SuperEntity> List<T> getEntityList(List<? extends SuperDTO> dtos) {
        return dtos.stream().map(Converter::<T>getEntity).collect(Collectors.toList());

    }

//    public static <T extends SuperDTO> List<T> getDtTList(List<? extends SuperEntity> entities) {
//        SuperEntity o = (SuperEntity) entities.get(1);
//        if (o instanceof Member) {
//            List<MemberDTO> dtos = new ArrayList<>();
//            for (Object e : entities) {
//                Member c = (Member) e;
//                dtos.add((MemberDTO) getDTO(c));
//
//            }
//            return (List<T>) dtos;
//        } else if (o instanceof Book) {
//            List<BookDTO> dtos = new ArrayList<>();
//            for (Object e : entities) {
//                Book c = (Book) e;
//                dtos.add((BookDTO) getDTO(c));
//            }
//            return (List<T>) dtos;
//
//        } else {
//            throw new RuntimeException("This Entity list cant be convert to a DTO List");
//        }
//    }

//
//    public static <T extends SuperEntity> List<T> getEntityList(List<? extends SuperDTO> dtos) {
//       SuperDTO d = (SuperDTO) dtos.get(0);
//       if (d instanceof MemberDTO){
//           List<Member> list = new ArrayList<>();
//           dtos.forEach(c->{
//               list.add(getEntity(c));
//           });
//           return (List<T>) list;
//
//       }  else if (d instanceof BookDTO){
//           List <Member> list = new ArrayList<>();
//           dtos.forEach(c->{
//               list.add(getEntity(c));
//
//           });
//           return (List<T>) list;
//       }else {throw new RuntimeException("There dto list cant be convert to an entity list");
//       }
//    }
}
