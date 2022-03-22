package newspaper;

import java.util.List;
import java.util.Objects;

public abstract class Article implements Comparable<Article>{

    protected String author;
    protected Header header;
    protected List<String> paragraphs;

    public Article() {
    }

    public Article(String author, Header header, List<String> paragraphs) {
        this.author = author;
        this.header = header;
        this.paragraphs = paragraphs;
    }

    public abstract int getImportance();

    @Override
    public int compareTo(Article o) {
        return o.getImportance() - this.getImportance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return header.getContent().equals(article.header.getContent()) && paragraphs.equals(article.paragraphs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header.getContent(), paragraphs);
    }

    public String getAuthor() {
        return author;
    }

    public Header getHeader() {
        return header;
    }

    public List<String> getParagraphs() {
        return List.copyOf(paragraphs);
    }
}
