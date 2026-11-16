package pattern.strategy;

public class JsonFormatStrategy implements FormatStrategy {
    @Override
    public String format(String rawText) {
        String escaped = rawText.replace("\\", "\\\\")
                                .replace("\"", "\\\"")
                                .replace("\n", "\\n")
                                .replace("\r", "\\r")
                                .replace("\t", "\\t");
        return "{\n  \"titulo\": \"Relatório\",\n  \"conteudo\": \""
                + escaped + "\"\n}\n";
    }

    @Override
    public String getExtension() {
        return "json";
    }
}
