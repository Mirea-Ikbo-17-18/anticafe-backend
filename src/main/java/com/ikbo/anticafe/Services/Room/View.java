package com.ikbo.anticafe.Services.Room;

import com.ikbo.anticafe.Models.Room;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@FunctionalInterface
public interface View {
    @Data
    @AllArgsConstructor
    class ViewRoom{
        private Long id;
        private String name;
        private String description;
        private Integer cost;
        private Date start;
        private Date finish;
        private List<Long> reservation_list;
    }
    ViewRoom transformRoom(Room room);
}
