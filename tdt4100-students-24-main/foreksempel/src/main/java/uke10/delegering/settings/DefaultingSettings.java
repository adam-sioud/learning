package uke10.delegering.settings;

import java.util.HashMap;
import java.util.Map;

public class DefaultingSettings implements ISettings {
Map<String, Object> getSettings();
	private MapSettings userSettings = new MapSettings();  // kunne vært deklarert som ISettings.
	private ISettings defaultSettings;

	public DefaultingSettings(ISettings defaultSettings) {
		this.defaultSettings = defaultSettings;
	}

	@Override
	public boolean hasSetting(final String s) {
		return userSettings.hasSetting(s) || defaultSettings.hasSetting(s);
	}

	@Override
	public Object getSetting(final String s) {
		if (userSettings.hasSetting(s)) {
			return userSettings.getSetting(s);
		}
		if (defaultSettings != null) {
			return defaultSettings.getSetting(s);
		}
		return null;
	}

	@Override
	public void updateSetting(final String s, final Object o) {
		userSettings.updateSetting(s, o);
	}

	public void addSettingsIfAbsent(Map<String, Object> result) {
		userSettings.addSettingsIfAbsent(result);
		defaultSettings.addSettingsIfAbsent(result);
	}

	private Map<String, Object> effectiveSettings() {
		
		Map<String, Object> result = new HashMap<>();
		addSettingsIfAbsent(result);
        return result;
    }

	public static void main(final String[] args) {

		// Se klasse og objekt-diagrammer i egne filer
		ISettings defaultGeneral = new MapSettings();
		ISettings generalSettings = new DefaultingSettings(defaultGeneral);
		ISettings settings = new DefaultingSettings(generalSettings);

		// Setting default general settings
		defaultGeneral.updateSetting("theme", "light");
		defaultGeneral.updateSetting("font", "times new roman");
		defaultGeneral.updateSetting("fullscreen", "yes");
		System.out.println("\nSettings after default general settings have been set");
		System.out.println("Font: "+settings.getSetting("font"));
		System.out.println("Theme: "+settings.getSetting("theme"));
		System.out.println("Fullscreen: "+settings.getSetting("fullscreen"));
		
		// Setting general user settings that override general default settings
		generalSettings.updateSetting("theme", "dark");
		generalSettings.updateSetting("font", "courier new");
        
		System.out.println("\nAfter setting user general settings");
		settings.updateSetting("font", "comic sans");
		System.out.println("Font: "+settings.getSetting("font"));
		System.out.println("Theme: "+settings.getSetting("theme"));
		System.out.println("Fullscreen: "+settings.getSetting("fullscreen"));

		
		settings.updateSetting("theme", "dark");
		System.out.println("\nAfter setting user project Settings");
		System.out.println("Font: "+settings.getSetting("font"));
		System.out.println("Theme: "+settings.getSetting("theme"));
		System.out.println("Fullscreen: "+settings.getSetting("fullscreen"));

		System.out.println(((DefaultingSettings)settings).effectiveSettings());
	}

}
