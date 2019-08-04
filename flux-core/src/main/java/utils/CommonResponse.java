package utils;

public class CommonResponse {

	private final int errCode;
	private final String description;

	//@formatter:off
	public CommonResponse(
				int errCode,
				String description
			) {

		this.errCode = errCode;
		this.description = description;
	}

	public int getErrCode() { return this.errCode; }
	public String getDescription() { return this.description; }

}
