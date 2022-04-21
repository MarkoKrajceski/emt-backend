package mk.ukim.finki.library.model.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class BookDto {

    private String name;

    private Long category;

    private Long author;

    private int availableCopies;

    public BookDto(String name, Long category, Long author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
