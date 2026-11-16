package pattern.strategy;

public class HtmlFormatStrategy implements FormatStrategy {
    @Override
    public String format(String rawText) {
        String safe = rawText.replace("&", "&amp;")
                             .replace("<", "&lt;")
                             .replace(">", "&gt;")
                             .replace("\r", "")
                             .replace("\n", "<br/>");
        return "<!DOCTYPE html>\n<html>\n<head>\n<meta charset=\"UTF-8\">\n"
                + "<title>Relatório</title>\n</head>\n<body>\n<h1>Relatório</h1>\n<p>"
                + safe
                + "</p>\n</body>\n</html>\n";
    }

    @Override
    public String getExtension() {
        return "html";
    }
}
