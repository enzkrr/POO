package pattern.strategy;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class DefaultExportStrategy implements ExportStrategy {
    @Override
    public ExportResult export(ExportRequest request, String rawText) {
        // Decora o texto bruto ANTES de formatar, para que HTML/JSON/Markdown continuem válidos
        StringBuilder body = new StringBuilder();

        if (request.isIncludeHeader()) {
            body.append("=== CABEÇALHO OFICIAL DE RELATÓRIO ===\n");
            body.append("Data: ").append(LocalDateTime.now()).append("\n\n");
        }

        if (request.isIncludeWatermark()) {
            body.append("[MARCA D'ÁGUA: CONFIDENCIAL]\n");
        }

        if (request.isIncludeBorder()) {
            body.append("****************************************\n");
        }

        body.append(rawText).append("\n");

        if (request.isIncludeBorder()) {
            body.append("****************************************");
        }

        FormatStrategy formatter = FormatStrategyFactory.getStrategy(request.getFormatName());
        String output = formatter.format(body.toString());

        String fileName = "resultado_exportacao." + formatter.getExtension();
        try {
            Files.writeString(Path.of(fileName), output, StandardCharsets.UTF_8);
            return ExportResult.success(fileName, output);
        } catch (IOException ex) {
            return ExportResult.error(ex.getMessage());
        }
    }
}
