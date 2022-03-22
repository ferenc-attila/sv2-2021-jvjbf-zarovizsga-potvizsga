package newspaper;

import java.util.List;

public class YellowPressArticle extends Article {

    public YellowPressArticle(String author, Header header, List<String> paragraphs) {
        super();
        validateLevel(header);
        this.author = author;
        this.header = header;
        this.paragraphs = paragraphs;
    }

    @Override
    public int getImportance() {
        return 1;
    }

    private void validateLevel(Header header) {
        if (header.getLevel() > 5) {
            throw new IllegalArgumentException("Header size cannot be greater than 5!");
        }
    }
}
