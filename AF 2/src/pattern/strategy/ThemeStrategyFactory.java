package pattern.strategy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ThemeStrategyFactory {
    private static final Map<String, ThemeStrategy> THEMES = new LinkedHashMap<>();

    static {
        THEMES.put("Claro", new LightThemeStrategy());
        THEMES.put("Escuro", new DarkThemeStrategy());
        THEMES.put("Azul", new BlueThemeStrategy());
    }

    public static ThemeStrategy getTheme(String themeName) {
        ThemeStrategy theme = THEMES.get(themeName);
        return theme != null ? theme : new LightThemeStrategy();
    }

    public static Set<String> getAvailableThemes() {
        return THEMES.keySet();
    }
}
