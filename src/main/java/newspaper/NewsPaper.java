package newspaper;

import java.util.*;

public class NewsPaper {

    private String name;
    private Set<Article> articles = new TreeSet<>();

    public NewsPaper(String name) {
        this.name = name;
    }

    public void addArticle (Article article) {
        articles.add(article);
    }

    public List<Article> findArticlesByAuthor (String author) {
        validateStringParameter(author);
        return articles.stream()
                .filter(article -> author.equals(article.getAuthor()))
                .toList();
    }

    public List<Article> findArticleByParagraphPart(String articlePart) {
        validateStringParameter(articlePart);
        return articles.stream()
                .filter(article -> !article.paragraphs.stream()
                        .filter(p -> p.contains(articlePart)).toList().isEmpty())
                .toList();
    }

    private void validateStringParameter(String stringParameter) {
        if (stringParameter == null || stringParameter.isBlank()) {
            throw new IllegalArgumentException ("Author cannot be null or empty!");
        }
    }

    public String getName() {
        return name;
    }

    public Set<Article> getArticles() {
        return Set.copyOf(articles);
    }
}
