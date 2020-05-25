//@category CppClassAnalyzer
import ghidra.app.script.GhidraScript;
import cppclassanalyzer.data.ArchivedDataManager;

public class ImportScript extends GhidraScript {

	@Override
	public void run() throws Exception {
		ArchivedDataManager aman = ArchivedDataManager.open(
			askFile("Choose an archive", "ok"));
		aman.importData(currentProgram, monitor);
	}
}