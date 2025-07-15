import java.util.ArrayDeque;

public class BrowserMain {
    ArrayDeque<String> backStack = new ArrayDeque<>();
    ArrayDeque<String> forwardStack = new ArrayDeque<>();
    String currentPage;

    public void visit(String url) {
        if (currentPage != null) {
            backStack.push(currentPage);
        }
        currentPage = url;
        forwardStack.clear();
    }

    public String back() {
        if (backStack.isEmpty()) {
            return currentPage;
        }
        forwardStack.push(currentPage);
        currentPage = backStack.pop();
        return currentPage;
    }

    public String forward() {
        if (forwardStack.isEmpty()) {
            return currentPage;
        }
        backStack.push(currentPage);
        currentPage = forwardStack.pop();
        return currentPage;
    }

    public String getCurrentPage() {
        return currentPage == null ? "You're not on a page" : currentPage;
    }
}
