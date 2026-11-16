package pattern.strategy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FormatStrategyFactory {
    private static final Map<String, FormatStrategy> STRATEGIES = new LinkedHashMap<>();

    static {
        STRATEGIES.put("Texto Puro", new PlainTextFormatStrategy());
        STRATEGIES.put("HTML", new HtmlFormatStrategy());
        STRATEGIES.put("Markdown", new MarkdownFormatStrategy());
        STRATEGIES.put("JSON", new JsonFormatStrategy());
    }

    public static FormatStrategy getStrategy(String formatName) {
        FormatStrategy strategy = STRATEGIES.get(formatName);
        return strategy != null ? strategy : new PlainTextFormatStrategy();
    }

    public static Set<String> getAvailableFormats() {
        return STRATEGIES.keySet();
    }
}
