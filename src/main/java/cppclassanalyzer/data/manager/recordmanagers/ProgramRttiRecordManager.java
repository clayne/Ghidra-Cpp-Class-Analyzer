package cppclassanalyzer.data.manager.recordmanagers;

import cppclassanalyzer.data.typeinfo.AbstractClassTypeInfoDB;
import cppclassanalyzer.data.vtable.AbstractVtableDB;

import cppclassanalyzer.database.record.ClassTypeInfoRecord;
import cppclassanalyzer.database.record.VtableRecord;

public interface ProgramRttiRecordManager extends
		RttiRecordManager<AbstractClassTypeInfoDB, AbstractVtableDB,
			ClassTypeInfoRecord, VtableRecord> {
}
