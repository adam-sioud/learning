package uke10.delegering.settings;

import java.util.Map;

public interface ISettings {
	boolean hasSetting(String s);
	Object getSetting(String s);
	void updateSetting(String s, Object o);
	void addSettingsIfAbsent(Map<String, Object> result);
}
