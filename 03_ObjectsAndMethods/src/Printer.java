public class Printer {

    private String queue = "";
    private String defaultTitle = "";
    private int defaultPages = 1;
    private int pagesCount = 0; // страниц добавлено
    private int documentCount = 0; // документов добавлено
    private int pagesPrinted = 0; // страниц распечатано с начала работы (всего)

    public void append(String text) {
        append(text, defaultTitle, defaultPages);
    }

    public void append(String text, String title) {
        append(text, title, defaultPages);
    }

    public void append(String text, int pages) {
        append(text, defaultTitle, pages);
    }

    public void append(String text, String title, int pages) {

        queue = queue + "\n" + text + title;
        pagesCount = pagesCount + pages;
        documentCount++;
    }

    public void clear() {

        queue = "";
        pagesCount = 0;
        documentCount = 0;
    }

    public void print() {

        if (queue.isEmpty()) {

            System.out.println("В очереди нет документов");
        } else {

            System.out.println("Документов в очереди - " + documentCount + ", страниц в очереди - " + pagesCount);
            pagesPrinted = pagesPrinted + pagesCount;
            clear();
        }
    }

    public void getPendingPagesCount() {

        if (pagesCount == 0) {
            System.out.println("Все документы распечатаны");
        } else {
            System.out.println("Страниц не распечатано - " + pagesCount);
        }
    }

    public void totalPages() {
        System.out.println("Всего распечатно страниц с первого запуска - " + pagesPrinted);
    }
}