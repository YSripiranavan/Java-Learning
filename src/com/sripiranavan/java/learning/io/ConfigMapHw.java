package com.sripiranavan.java.learning.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

public class ConfigMapHw {

	public static void main(String[] args) {
		String filePath = "configMap.txt";
		try {
			String result = getValueFromConfigMap(Paths.get("fileRead",filePath), "discount");
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getValueFromConfigMap(Path configMapFilePath, String keyName) throws IOException {
		if (configMapFilePath == null || keyName == null) {
			return null;
		}
		Map<String, String> collect = Files.lines(configMapFilePath).collect(
				Collectors.toMap(line -> ((String) line).split("=")[0], line -> ((String) line).split("=")[1]));
		return collect.get(keyName);
	}
}
