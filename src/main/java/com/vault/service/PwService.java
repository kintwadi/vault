package com.vault.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vault.dao.Dao;
import com.vault.logger.AppLogger;
import com.vault.model.Record;



@Service
public class PwService {

	@Autowired
	Dao dao;

	public void store(Record record)
	{

		dao.store(record);
	}

	public List<Record>retrieveAll()
	{
		return dao.retrieveAll();
	}

	public void fromCSV(MultipartFile file) 
	{

		try {

			List<Record> records = new ArrayList<Record>();
			String line = "";
			InputStream in = file.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			while(reader.ready()) 
			{
				line = reader.readLine();
				StringTokenizer token = new StringTokenizer(line, ",");
				Record record = new Record();
				record.setTitle(token.nextToken());
				record.setPassword(token.nextToken());
				record.setDescription(token.nextToken());
				records.add(record);
			}
			if(!records.isEmpty())
				dao.batchStore(records);

		} catch (Exception e) {
			AppLogger.getInstance(this).trace(e.getLocalizedMessage());
		} // end of exception handling

	}
}
