package com.pcwk.ehr.share;

import java.sql.SQLException;
import java.util.List;

import javax.print.attribute.standard.SheetCollate;


public interface shareService {
	

	public List<shareVO> urlSelect(shareVO search) throws SQLException;

}
