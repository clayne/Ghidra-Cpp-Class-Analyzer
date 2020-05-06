package ghidra.program.database.data.rtti;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

import ghidra.app.cmd.data.rtti.TypeInfo;
import ghidra.app.cmd.data.rtti.gcc.UnresolvedClassTypeInfoException;
import ghidra.app.cmd.data.rtti.gcc.typeinfo.TypeInfoModel;
import ghidra.program.database.ProgramDB;
import ghidra.program.model.address.Address;
import ghidra.program.model.data.Structure;
import ghidra.program.model.listing.Program;

/**
 * Manager for {@link TypeInfo}
 */
public interface TypeInfoManager {

	static final Map<Program, TypeInfoManager> MANAGERS =
		Collections.synchronizedMap(new WeakHashMap<>());

	static TypeInfoManager getManager(Program program) {
		if (MANAGERS.containsKey(program)) {
			return MANAGERS.get(program);
		}
		ClassTypeInfoManager manager = new ClassTypeInfoManagerDB((ProgramDB) program);
		MANAGERS.put(program, manager);
		return manager;
	}

	/**
	 * Get the TypeInfo at the address
	 * @param address the address of the TypeInfo
	 * @return the TypeInfo at the specified address or null if none exists.
	 */
	TypeInfo getTypeInfo(Address address) throws UnresolvedClassTypeInfoException;

	/**
	 * Checks if a valid TypeInfo is located at the address in the program.
	 * @param address the address of the TypeInfo
	 * @return true if the data is a valid TypeInfo
	 */
	boolean isTypeInfo(Address address);

	/**
	 * Invokes getDataType on the TypeInfo containing the specified typename
	 * @param program the program containing the TypeInfo
	 * @param typename the type_info class's typename
	 * @return the TypeInfo structure for the typename
	 * @see TypeInfoModel#getDataType()
	 */
	Structure getDataType(String typename);

}