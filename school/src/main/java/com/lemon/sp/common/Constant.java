package com.lemon.sp.common;


/**
   * @ClassName: Constant
   * @Description: 系统中涉及到的常量
   * @author 张金龙
   * @date 2015年1月8日 上午11:07:26
 */

public class Constant { 
	//试题类型
	public static enum   QuestionType{
		//写作
		WRITING(16) ,
		//口语
		SPOKEN_LANGUAGE(17) ;
		public Integer code ;
		QuestionType(Integer code){
			this.code = code ;
		}
	}
	//特殊班型
	public static final String[] SPECIAL_COURSE_CODE = {"13295" , "13296" , "13297","13715"} ;
	public static final String SPECIAL_COURSE_CODE_Str = "'13295','13296','13297','13715'";
	//APP支持题型
	public static final String APP_CHECK_NO_EX = "'5','7','9','12','17'";
	// 服务器基路径 http://testielts2.staff.xdf.cn
	public static String BaseUrl = OAuthAppConfig.getString("baseUrl");
	// 项目基路径 http://testielts2.staff.xdf.cn/IELTS_2
	public static String DOMAIN = BaseUrl + OAuthAppConfig.getString("Domain");
	// 系统所有文件 上传基地址  /usr/userdata/IELTS_2_UPLOAD
	public static String uploadUrl 	=  OAuthAppConfig.getString("uploadUrl");
	// 系统所有文件 映射基地址  /upload
	public static String uploadUrlMapped =  OAuthAppConfig.getString("uploadUrlMapped");
	// 试卷打包路径 /paperzip
	public static String PAPER_FOLDER = OAuthAppConfig.getString("PaperFolder");
	// 文件上传的目录名、学生口语试题上传文件、上传文件的临时存储目录 /fileupload
	public static String FileFolder = OAuthAppConfig.getString("FileFolder");

	// 上传视频备份目录 /usr/userdata/IELTS_2_UPLOAD/backupFolder
	public static String backupFolder = uploadUrl + OAuthAppConfig.getString("backupFolder");
	// 资料预览html
	public static String MaterialsFolder = OAuthAppConfig.getString("MaterialsFolder");
	// 上传文件的临时存储目录 /usr/userdata/IELTS_2_UPLOAD/fileupload
	public static String TempUploadFolder = uploadUrl + FileFolder;
	
	// 用户头像路径
	public static final String userImage = "/userImage";
	//入学测试推荐课程图片
	public static final String ENTRANCEEXAMPIC = "/entranceExamPic";
	
	// 广告图片地址 
	public static final String ADVERTIMAGE ="/advertImage";
	// 缩略图地址 
	public static final String Thumbnail ="/thumbnail";
	// 学生上传成绩单地址 
	public static final String STUDENTREPORT ="/studentReport";
	// 缩略图地址 
	public static final String QuestionFile ="/question";
	// 教师评价图片地址
	public static final String commentImage = "/commentImage";
	// 教师评价图片地址
	public static final String openClassImage = "/openClassImage";
	//报告模板地址
	public static final String reportTemplate ="/mockTemplate/mock.xlsx";
	//直播课海报
	public static final String liveTelecast = "/liveTelecast";
	//自由任务
	public static final String freeTask = "/freeTask";
	//课次反馈附件地址
	public static final String feedbackFile = "/feedbackFile";
	//周中测
	public static final String midwkTest = "/midwkTest";
	//指定班级导出模板地址
	public static final String dataClassTemplate ="/mockTemplate/data.xlsx";
	// ios路径
	public static final String iosuploadurl = "/app/ios";
	// android路径
	public static final String androiduploadurl = "/app/android";
	//公共目录
	public static final String appuploadurl = "/app";

	
	// 用户头像上传路径
	public static final String userImageUploadUrl = uploadUrl + userImage;
	// 直播课海报上传
	public static final String liveTelecastUploadUrl = uploadUrl + liveTelecast;
	// 自由任务上传
	public static final String freeTaskUploadUrl = uploadUrl + freeTask;
	// 周中测附件上传
	public static final String midwkTestUploadUrl = uploadUrl + midwkTest;
	// 自由任务访问(映射)路径
	public static final String freeTaskUrl = BaseUrl + uploadUrlMapped + freeTask;
	// 周中测附件访问(映射)路径
	public static final String midwkTestUrl = BaseUrl + uploadUrlMapped + midwkTest;
	// 课次反馈上传
	public static final String feedbackUploadUrl = uploadUrl + feedbackFile;
	// 课次反馈访问(映射)路径
	public static final String feedbackUrl = BaseUrl + uploadUrlMapped + feedbackFile;

	// 入学测试推荐课程上传路径
	public static final String entranceExamUploadUrl = uploadUrl + ENTRANCEEXAMPIC;
	// 用户头像访问(映射)路径
	public static final String userImageMapped = BaseUrl + uploadUrlMapped + userImage;
	// 入学测试推荐课程访问(映射)路径
	public static final String entranceExamMapped = BaseUrl + uploadUrlMapped + ENTRANCEEXAMPIC;
	// 广告图片上传路径
	public static final String advertImageUploadUrl = uploadUrl + ADVERTIMAGE;
	// 缩略图上传路径
	public static final String thumbnailUploadUrl = uploadUrl + Thumbnail;
	//缩略图宽
	public static final int thumbnailWideth414 = 414;
	//缩略图高
	public static final int thumbnailHeight160 = 160;
	// 学生上传成绩单地址 
	public static final String studentReportUploadUrl = uploadUrl+STUDENTREPORT;
	// 试卷压缩包访问(映射)路径
	public static final String PaperZipFolderUrl = BaseUrl + uploadUrlMapped + PAPER_FOLDER;
	// 试题上传路径
	public static final String questionFileUploadUrl = uploadUrl + QuestionFile;
	// 广告、预测上传路径
	public static final String advertAndPredictFileUploadUrl = uploadUrl + ADVERTIMAGE;
	// 试题访问(映射)路径
	public static final String questionFileMappedUrl = BaseUrl + uploadUrlMapped + QuestionFile;
	// 预测、广告访问(映射)路径
	public static final String advertAndPredictFileMappedUrl = BaseUrl + uploadUrlMapped + ADVERTIMAGE;
	// 教师评价图片上传路径
	public static final String commentImageUploadUrl = uploadUrl + commentImage;
	//教师评价图片显示路径
	public static final String showcommentImage = BaseUrl + uploadUrlMapped + commentImage;
	//报告模板路径
	public static final String REPORTTEMPLATEURL=uploadUrl + reportTemplate;
	// 公开课图片上传路径
	public static final String openClassImageUploadUrl = uploadUrl + openClassImage;
	//公开课图片显示路径
	public static final String showOpenClassImage = BaseUrl + uploadUrlMapped + openClassImage;
	//指定班级导出模板地址路径
	public static final String DATACLASSMPLATEURL=uploadUrl + dataClassTemplate;
	// App android包上傳
	public static final String androidUploadUrl = uploadUrl + androiduploadurl;
	//App android包显示路径
	public static final String showAndroidUploadUrl = BaseUrl + uploadUrlMapped + androiduploadurl;
	// Appios包上傳
	public static final String iosUploadUrl = uploadUrl + iosuploadurl;
	//Appios包显示路径
	public static final String showIosUploadUrl = BaseUrl + uploadUrlMapped + iosuploadurl;
	// 公共包包上傳
	public static final String appUploadUrl = uploadUrl + appuploadurl;
	//公共目录展示
	public static final String showAppUploadUrl = BaseUrl + uploadUrlMapped + appuploadurl;
	
	//souke
	public static String SOUKE_URL = OAuthAppConfig.getString("SOUKE_URL");
	public static String CLIENT_ID = OAuthAppConfig.getString("CLIENT_ID");
	public static String CLIENT_SECRET = OAuthAppConfig.getString("CLIENT_SECRET");
	
	//乐词
	public static String LECI_URL = OAuthAppConfig.getString("LECI_URL");
	
	// 教师图像路径
	public static String ImageUrl = OAuthAppConfig.getString("CDNImageUrl");
	public static String ImageKey = OAuthAppConfig.getString("CDNImageKey");
	public static String ImageName = OAuthAppConfig.getString("CDNImageName");
	
	// E2接口配置(新东方统一帐户登录界面)
	public static String E2AuthorizeUrl 	= OAuthAppConfig.getString("E2AuthorizeUrl");
	public static String E2AccessTokenUrl 	= OAuthAppConfig.getString("E2AccessTokenUrl");
	public static String E2LogoutUrl 		= OAuthAppConfig.getString("E2LogoutUrl");
	public static String ClientId 			= OAuthAppConfig.getString("ClientId");
	public static String ClientSecret 		= OAuthAppConfig.getString("ClientSecret");
	public static String CallbackUrl 		= DOMAIN + OAuthAppConfig.getString("CallbackUrl");
	public static String logoffCallbackUrl  = DOMAIN + OAuthAppConfig.getString("LogoffCallbackUrl");
	    
	//教师  U2接口配置(新东方帐户登录接口)
	public static String U2ApiUrl			= OAuthAppConfig.getString("U2ApiUrl");
	public static String U2AppID			= OAuthAppConfig.getString("U2AppID");
	public static String U2AppKey			= OAuthAppConfig.getString("U2AppKey");
	public static String U2LoginUrl			= OAuthAppConfig.getString("U2LoginUrl");
	
	//学生 U2接口配置(新东方帐户登录接口)
	public static String U2LoginUrl_S		= OAuthAppConfig.getString("U2LoginUrl_S");
	//教师U2接口配置(新东方帐户登录接口)
	public static String U2LoginUrl_T		= OAuthAppConfig.getString("U2LoginUrl_T");
	//首页注册地址
	public static String U2RigestUrl		= OAuthAppConfig.getString("U2RigestUrl");
	
	
	public static int LOGIN_STUDENT 		= 2;//学生登陆
	public static int LOGIN_TEACHER		    = 1;//教师登陆
	    
	// V5接口配置(新东方教师身份验证和教师信息系统)
	public static String V5ApiUrl			= OAuthAppConfig.getString("V5ApiUrl");
	public static String V5AppID			= OAuthAppConfig.getString("V5AppID");
	public static String V5AppKey			= OAuthAppConfig.getString("V5AppKey");
	
	// V5接口配置(新东方日历信息系统)
	public static String V5CalendarUrl			= OAuthAppConfig.getString("V5CalendarUrl");
	
	// V5接口配置(新东方互动中心课次API)
	public static String V5InteractiveLessonUrl			= OAuthAppConfig.getString("V5InteractiveLessonUrl");
	
	//友盟推送接口配置
	public static String UMENG_HOST = OAuthAppConfig.getString("UmengHost");
	public static String UMENG_UPLOAD_PATH = OAuthAppConfig.getString("UmengUploadPath");
	public static String UMENG_POST_PATH = OAuthAppConfig.getString("UmengPostPath");
	public static String UMENG_USER_AGENT = OAuthAppConfig.getString("UmengUserAgent");
	
	//测试还是产线环境true/false,正式/测试模式
	public static String UMENG_PROD_MODE = OAuthAppConfig.getString("UmengProductionMode");
	
	//友盟推送安卓应用
	public static String UMENG_ANDROID_KEY = OAuthAppConfig.getString("UmengAndroidAppKey"); //安卓appkey
	public static String UMENG_ANDROID_SECRET = OAuthAppConfig.getString("UmengAndroidAppMasterSecret"); //安卓appMasterSecret
	//推送安卓手机默认title和ticker
	public static final String PUSH_MESSAGE_TITLE = OAuthAppConfig.getString("AndroidTitle"); // title
	public static final String PUSH_MESSAGE_TICKER = OAuthAppConfig.getString("AndroidTicker"); // ticker
	//友盟推送苹果应用
	public static String UMENG_IOS_KEY = OAuthAppConfig.getString("UmengIOSAppKey"); //苹果appkey
	public static String UMENG_IOS_SECRET = OAuthAppConfig.getString("UmengIOSAppMasterSecret"); //苹果appMasterSecret
	
	// CDN地址
	public static String CDNUrl			= OAuthAppConfig.getString("CDNUrl");
	    
	// 教师端门户页面集成平台TP的Secret
	public static String TPSecret			= OAuthAppConfig.getString("TPSecret");
	
	//互动平台上传同步头像
	public static String AVATAR_IMGURL_URL			= OAuthAppConfig.getString("AVATAR_IMGURL_URL");
	public static String UPLOADAVATAR_URL			= OAuthAppConfig.getString("UPLOADAVATAR_URL");
	public static String UPLOADAVATAR_SECRETKEY			= OAuthAppConfig.getString("UPLOADAVATAR_SECRETKEY");
	
	public static final String DEFAULT_ICON = "defIcon.png";
	
	// ScheduleTask表TaskType字段含义
	public static final int TaskType_ScheduleTask_PaperInfo_MK = 1; // 模考
	public static final int TaskType_ScheduleTask_PaperInfo_LX = 2; // 练习
	public static final int TaskType_ScheduleTask_Materials = 3; // 资料
	public static final int TaskType_ScheduleTask_Test = 4; // 测试
	public static final int TaskType_ScheduleTask_Free = 5; // 自由任务
	
	public static final String TASKTYPE_EXAM_CODE = "1";// 模考
	public static final String TASKTYPE_PRACTISE_CODE = "2"; // 练习
	public static final String TASKTYPE_MATERIALS_CODE = "3";// 资料
	public static final String TASKTYPE_TEST_CODE = "4";// 测试
	
	public static final int QCTYPE_TEXT = 1; //文本内容
	
	public static final int QCTYPE_FILE = 2; //文件
	
	/**
	 * 集团
	 */
	public static final String ROLE_GROUP = "1";
	/**
	 * 教师
	 */
	public static final String ROLE_TEACHER = "2";
	/**
	 * 学生
	 */
	public static final String ROLE_STUDENT = "3";
	/**
	 * 主管
	 */
	public static final String ROLE_ADMIN_MANAGE = "4";
	/**
	 * 学管
	 */
	public static final String ROLE_STUDENT_MANAGE = "5";
	/**
	 * 游客
	 */
	public static final String ROLE_VISITOR = "6";
	
	public static final String ROLE_GROUP_STR = "集团";
	public static final String ROLE_TEACHER_STR = "老师";
	public static final String ROLE_STUDENT_STR = "学生";
	public static final String ROLE_ADMIN_MANAGE_STR = "主管";
	public static final String ROLE_STUDENT_MANAGE_STR = "学管";
	public static final String ROLE_VISITOR_STR = "游客";
	
	public static final String PAPER_STR = "试卷";// 试卷
	
	public static final String CORRECTED_EXAM_UNCOM = "0";// 试卷未完成批改
	public static final String CORRECTED_EXAM_COM = "1";// 试卷批改完成
	//批改终端标示字段
	public static final int CORRECTED_EXAM_ENDPOINT_APP = 0;// app端
	public static final int CORRECTED_EXAM_ENDPOINT_WEB = 1;// web端
	
	public static final String TASKTYPE_EXAM_STR = "模考";// 模考
	public static final String TASKTYPE_PRACTISE_STR = "练习"; // 练习
	public static final String TASKTYPE_MATERIALS_STR = "资料";// 资料
	public static final String TASKTYPE_TEST_STR = "测试";// 测试

	public static final String TASKTYPE_DATA_MATERIALS_STR = "资料题";// 资料题
	
	// ScheduleTask表TaskProperty字段含义
	public static final int TaskProperty_YX = -1; // 任务性质 -1=预习
	public static final int TaskProperty_ST = 0; // 任务性质 0=随堂
	public static final int TaskProperty_FX = 1; // 任务性质 1=复习
	
	// ExamInfo表ExamProperty字段含义
	public static final int ExamInfo_ExamProperty_RegularEX = 1; // 判卷类型 1正规判卷
	public static final int ExamInfo_ExamProperty_ActiveClassEX = 2; // 判卷类型 2随堂练习
	public static final int ExamInfo_ExamProperty_MaterialsEX = 3; // 判卷类型 3资料练习
	
	// LabelCategory表NameCode字段含义
	public static final String LabelCategory_NameCodeTL = "TL"; // 听力
	public static final String LabelCategory_NameCodeKY = "KY"; // 口语
	public static final String LabelCategory_NameCodeYD = "YD"; // 阅读
	public static final String LabelCategory_NameCodeXZ = "XZ"; // 写作
	public static final String LabelCategory_NameCodeCH = "CH"; // 词汇
	public static final String LabelCategory_NameCodeYF = "YF"; // 语法
	public static final String LabelCategory_NameCodeZH = "ZH"; // 综合
	public static final String LabelCategory_NameCodeWF = "WF"; // sat模考文法
	public static final String LabelCategory_NameCodeSX = "SX2"; // sat模考数学
	public static final String LabelCategory_NameCodeSXNC = "SX1"; // sat模考数学no 计算机
	public static final String LabelCategory_NameCodeSXALL = "SX"; // sat模考数学的统一标签
	
	// LabelCategory表TypeCode字段含义
	public static final String LabelCategory_TypeCodeST = "ST"; // 试题
	public static final String LabelCategory_TypeCodeSJ = "SJ"; // 试卷
	public static final String LabelCategory_TypeCodeSJLX = "SJLX"; // 试卷类型
	public static final String LabelCategory_TypeCodeSTLX = "STLX"; // 试卷类型
	public static final String LabelCategory_TypeCodeZL = "ZL"; // 资料
	
	public static final String LabelCategory_TypeCodeSACT = "SACT"; // 科目
	
	
	public static final String LabelCategory_TypeCodeCSFL = "CSFL"; // SAT测试分类
	public static final String LabelCategory_TypeCodeCC = "CC"; // 出处
	public static final String LabelCategory_TypeCodeWZHT = "WZHT"; // 文章话题
	public static final String LabelCategory_TypeCodeXZHT = "XZHT"; // 写作话题
	public static final String LabelCategory_TypeCodeXZLX = "XZLX"; // 写作类型
	
	// LabelCategory表Type2Code字段含义
	public static final String LabelCategory_Type2CodeYS = "YS"; // 雅思
	public static final String LabelCategory_Type2CodeTF = "TF"; // 托福
	public static final String LabelCategory_Type2CodeSAT = "SAT"; // sat
	public static final String LabelCategory_Type2CodeLiuX = "LiuX"; // 留学
	public static final String LabelCategory_Type2CodeKQHG = "KQHG"; // 考情回顾
	public static final String LabelCategory_Type2CodeSACT = "SACT"; // sat->资料->用途->sact
	public static final String LabelCategory_Type2CodeMK = "MK"; // 模考
	public static final String LabelCategory_Type2CodeLX = "LX"; // 练习
	public static final String LabelCategory_Type2CodeCS = "CS"; // 测试
	public static final String LabelCategory_Type2CodeZL = "ZL"; // 资料
	public static final String LabelCategory_Type2CodeZLT = "ZLT"; // 资料题
	public static final String LabelCategory_Type2CodeKS = "KS"; // SAT考试
	public static final String LabelCategory_Type2CodeSATKS = "SAT"; // SAT考试下的科目
	public static final String LabelCategory_Type2CodeCSLX = "CSLX"; // TOEFL测试下的类型
	public static final String LabelCategory_Type2CodeSATCC = "SATCC"; // SAT出处
	public static final String LabelCategory_Type2CodeSATWZHT = "SATWZHT"; // SAT文章话题
	public static final String LabelCategory_Type2CodeSATXZHT = "SATXZHT"; // SAT写作话题
	public static final String LabelCategory_Type2CodeSATXZLX = "SATXZLX"; // SAT写作类型
	public static final String LabelCategory_Type2CodeYDWZHT = "YDWZHT"; // 阅读 文章话题
	
	public static final String LabelCategory_Type2CodeKM = "KM"; // SACT
	
	
	//试题类型
	public static final String KY = "口语";
	
	public static final String TL = "听力";

	public static final String YD = "阅读";
	
	public static final String SELECT_QUESTION = "选择题";
	public static final String FILL_QUESTION = "填空题";
	public static final String JD_QUESTION = "简答题";
	
	public static final String YS = "雅思";
	public static final String TF = "托福";
	public static final String SAT = "SAT";
	
	public static final String KQHG = "考情回顾";
	
	public static final String TEACHER_REMIND = "教师提醒";
	
	public static final String NO_CORRECT = "待批改";
	public static final String NO_FINISH = "未完成";
	public static final String WAIVER = "弃权";
	
	//项目名称
	public static final String PROJECT_NAME = "IELTS";
	
	//试题类型
	public static final String QUESTION_TYPE_BWRITE = "大作文";
	
	public static final String QUESTION_TYPE_SWRITE = "小作文";
	
	public static final String QUESTION_TYPE_WRITE = "写作";
	
	/**
	 * 字典表类型
	 */
	public static final String DIC_TYPE_COMPLETEIELTS = "completeielts";
	
	/**
	 * 题目类型(父级)：基础库
	 */
	public static final String SubQuestionType_Code_ParentJC = "100";
	/**
	 * 题目类型(父级)：客观题
	 */
	public static final String SubQuestionType_Code_ParentKG = "200";
	/**
	 * 题目类型(父级)：主观题
	 */
	public static final String SubQuestionType_Code_ParentZG = "300";
	
	/**
	 * 题目类型(子级)：文本选择题、多媒体选择题、下拉选择题(ApplyPhone=1)
	 */
	public static final String[] SubQuestionType_Code_CHOOSE = { "5", "6", "8" };
	/**
	 * 题目类型(子级)：T/N/F 类选择题(是非题)(ApplyPhone=1)
	 */
	public static final String[] SubQuestionType_Code_RIGHTORWRONG = {"7"};
	/**
	 * 题目类型(子级)：段落填空题、补全单词题(ApplyPhone=1)
	 */
	public static final String[] SubQuestionType_Code_FILL = { "9", "10", "11",	"12" };
	/**
	 * 题目类型(子级)：主观简答题
	 */
	public static final String[] SubQuestionType_Code_SAQs = {"15"};
	
	public enum SubQuestionType_QT{
		/**
		 * 题目类型(子级)，文本、多媒体、下拉选择题：1选择题
		 */
		CHOOSE(1),
		/**
		 * 题目类型(子级)，T/N/F 类选择题(是非题)：2是非题
		 */
		RIGHTORWRONG(2),
		/**
		 * 题目类型(子级)，补全单词题、段落、表格、图片填空题：3填空题
		 */
		FILL(3);
		
		private int code;
		private SubQuestionType_QT(int code){
			this.code = code;
		}
		@Override
		public String toString(){
			return String.valueOf(this.code);
		}
		public Integer toInteger(){
			return Integer.valueOf(this.code);
		}
	}
	
	public static final String app_ucc_width  = "100%"; //视频宽度
	public static final String app_ucc_height = "100%"; //视频高度
	
	public static final String bValid = "1"; //可用
	public static final String nValid = "0"; //不可用
	
	public static final int IsSubjective_YES = 1;// 主观题
	public static final int IsSubjective_NO = 0; // 客观题
	
	
	public enum AdvertisementLocation_Status{
		/**
		 * AdvertisementLocation表Status字段含义 0不可用
		 */
		DEAD("0"),
		/**
		 * AdvertisementLocation表Status字段含义 1可用
		 */
		ALIVE("1");
		
		private String code;
		private AdvertisementLocation_Status(String code){
			this.code = code;
		}
		@Override
		public String toString(){
			return String.valueOf(this.code);
		}
	}
	
	public enum IsPublished{
		/**
		 * 通用字段IsPublished字段含义：0未发布
		 */
		NO("0"),
		/**
		 * 通用字段IsPublished字段含义：1已发布
		 */
		YES("1");
		
		private String code;
		private IsPublished(String code){
			this.code = code;
		}
		@Override
		public String toString(){
			return String.valueOf(this.code);
		}
	}
	
	/**
	 * PapersInfo表字段PaperState试卷状态含义
	 */
	public enum PapersInfo_PaperState{
		/**
		 * 0 试卷初始创建
		 */
		ZERO("0"),
		/**
		 * 1 试卷未发布
		 */
		ONE("1"),
		/**
		 * 2 试卷发布成功等待打包
		 */
		TWO("2"),
		/**
		 * 3 试卷打包完成
		 */
		THREE("3");
		
		private String code;
		private PapersInfo_PaperState(String code){
			this.code = code;
		}
		@Override
		public String toString(){
			return String.valueOf(this.code);
		}
	}
	
	public enum ActiveClass_ClassStatus{
		/**
		 * 随堂练习 课堂状态：0未上课
		 */
		NO(0),
		/**
		 * 随堂练习 课堂状态：1上课中
		 */
		DOING(1),
		/**
		 * 随堂练习 课堂状态：2已下课
		 */
		DONE(2);
		
		private int code;
		private ActiveClass_ClassStatus(int code){
			this.code = code;
		}
		@Override
		public String toString(){
			return String.valueOf(this.code);
		}
		public Integer toInteger(){
			return Integer.valueOf(this.code);
		}
	}
	
	public enum ActiveClassStudent_LoginStatus{
		/**
		 * 课堂互动 学生在线状态：0离线
		 */
		OFFLINE(0),
		/**
		 * 课堂互动 学生在线状态：1在线
		 */
		ONLINE(1);
		
		private int code;
		private ActiveClassStudent_LoginStatus(int code){
			this.code = code;
		}
		@Override
		public String toString(){
			return String.valueOf(this.code);
		}
		public Integer toInteger(){
			return Integer.valueOf(this.code);
		}
	}
	
	public enum Users_LoginStatus{
		/**
		 * 系统验证的用户登录状态：-1验证没通过
		 */
		FAILED(-1),
		/**
		 * 系统验证的用户登录状态：0未开通使用系统权限
		 */
		ZERO(0),
		/**
		 * 系统验证的用户登录状态：1允许登录
		 */
		SUCCESS(1);
		
		private int code;
		private Users_LoginStatus(int code){
			this.code = code;
		}
		@Override
		public String toString(){
			return String.valueOf(this.code);
		}
		public Integer toInteger(){
			return Integer.valueOf(this.code);
		}
	}
	
	public enum RelActiveClassPaperInfo_Pushstatus{
		/**
		 * 随堂练习 推送状态： 0未推送
		 */
		NO(0),
		/**
		 * 随堂练习 推送状态： 1已推送
		 */
		YES(1),
		/**
		 * 随堂练习 推送状态： 2已完成
		 */
		DONE(2),
		/**
		 * 随堂练习 推送状态：3强制退出，单题提交达到百分比
		 */
		FORCE(3);
		
		private int code;
		private RelActiveClassPaperInfo_Pushstatus(int code){
			this.code = code;
		}
		@Override
		public String toString(){
			return String.valueOf(this.code);
		}
		public Integer toInteger(){
			return Integer.valueOf(this.code);
		}
	}
	
	public enum ActiveClassStudentAnswer_SubmitStatus{
		/**
		 * 随堂练习学生作答 提交状态：0未提交
		 */
		NO(0),
		/**
		 * 随堂练习学生作答 提交状态：1已提交(自动)
		 */
		YES_AUTO(1),
		/**
		 * 随堂练习学生作答 提交状态：2已提交(强制)
		 */
		YES_FORCE(2);
		
		private int code;
		private ActiveClassStudentAnswer_SubmitStatus(int code){
			this.code = code;
		}
		@Override
		public String toString(){
			return String.valueOf(this.code);
		}
		public Integer toInteger(){
			return Integer.valueOf(this.code);
		}
	}
	
	public enum PAPER_EVALUATE_TYPE{
		/**
		 * 判卷类型 1正规判卷
		 */
		ONE(1),
		/**
		 * 判卷类型 2随堂练习
		 */
		TWO(2),
		/**
		 * 判卷类型 3资料练习
		 */
		THREE(3);
		
		private int code;
		private PAPER_EVALUATE_TYPE(int code){
			this.code = code;
		}
		@Override
		public String toString(){
			return String.valueOf(this.code);
		}
		public Integer toInteger(){
			return Integer.valueOf(this.code);
		}
	}
	
	// 通用字段IsDelete字段含义
	public static final String COMMON_NO_DELETE = "0"; // 未删除
	public static final String COMMON_DELETE = "1"; // 已删除
	
	/**
	 * 通用字段BValid字段含义:无效
	 */
	public static final String COMMON_BValid_NO = "0";
	/**
	 * 通用字段BValid字段含义:有效
	 */
	public static final String COMMON_BValid_YES = "1";
	
	// StudentTargetDate表TaskState字段含义
	public static final String STUDENT_TARGET_DATE_TASKSTATE_NO_FOUND = "0"; // 尚未创建任务
	public static final String STUDENT_TARGET_DATE_TASKSTATE_FOUND = "1"; // 创建了任务	
	
	public static final String COMPLETE_IELTS_KEYWORD_STR = "雅思全日制";// 数据库查找时的 雅思全日制(初级，中级，高级)课程 关键字
	public static final String COMPLETE_IELTS_ALL_CLASS_FIT_STR = "全课程适用";// 数据库查找时的 全课程适用 关键字
	
	public static final String ALL_STR = "全部";// 全部
	
	public static final String NO_CONDITION = "0";// 不限类型
	
	public static final String UNIT_STR = "Unit";// 单元, 关键字
	
	public static final String TASK_STATUS_UNUSED_STR = "0";//分配任务的状态. 1代表任务已使用 或 正在使用，分配任务的地方不允许删除 . 0代表未使用，可以删除
	public static final String TASK_STATUS_USED_STR = "1";//分配任务的状态. 1代表任务已使用 或 正在使用，分配任务的地方不允许删除 . 0代表未使用，可以删除
	
	public static final String TIME_TYPE_WEEK = "1"; // 筛选条件时间类型-本周
	public static final String TIME_TYPE_MONTH = "2"; // 筛选条件时间类型-本月
	public static final String TIME_TYPE_YEAR = "3"; // 筛选条件时间类型-本年
	
	public static final String FILE_TYPE_WORD = "1"; // 筛选条件文件类型-WORD
	public static final String FILE_TYPE_EXCEL = "2"; // 筛选条件文件类型-EXCEL
	public static final String FILE_TYPE_PPT = "3"; // 筛选条件文件类型-PPT
	public static final String FILE_TYPE_PDF = "4"; // 筛选条件文件类型-PDF
	public static final String FILE_TYPE_VIDEO = "5"; // 筛选条件文件类型-视频
	
	public static final String MATERIALS_DOCUMENT_WORD_STR = "word"; //资料, 文件类型, word
	public static final String MATERIALS_DOCUMENT_EXCEL_STR = "excel"; //资料, 文件类型, excel
	public static final String MATERIALS_DOCUMENT_PPT_STR = "ppt"; //资料, 文件类型, ppt
	public static final String MATERIALS_DOCUMENT_PDF_STR = "pdf"; //资料, 文件类型, pdf
	public static final String MATERIALS_DOCUMENT_VIDEO_STR = "video"; //资料, 文件类型, video
	public static final String MATERIALS_DOCUMENT_AUDIO_STR = "mp3"; //资料, 文件类型, 音频
	
	public static final String MATERIALS_DOCUMENT_WORD = "('doc', 'docx')"; //资料数据库中存的文本文件后缀类型-WORD
	public static final String MATERIALS_DOCUMENT_EXCEL = "('xls', 'xlsx')"; //资料数据库中存的文本文件后缀类型-EXCEL
	public static final String MATERIALS_DOCUMENT_PPT = "('ppt', 'pptx')"; //资料数据库中存的文本文件后缀类型-PPT
	public static final String MATERIALS_DOCUMENT_PDF = "('PDF', 'pdf', 'Pdf')"; //资料数据库中存的文本文件后缀类型-PDF
	public static final String MATERIALS_DOCUMENT_AUDIO = "('mp3', 'wav')"; //资料数据库中存的音频文件后缀名
	public static final String MATERIALS_VIDEO_TYPES = "('mp4', 'MP4', 'Mp4', 'flv', 'Flv', 'FLV', 'wmv', 'Wmv', 'WMV')";//资料数据库中存的视频文件后缀类型， 查找时用
	public static final String MATERIALS_DOCUMENT_TYPES = "('doc', 'docx', 'ppt', 'pptx', 'xls', 'xlsx')";//资料数据库中存的文本文件后缀类型， 查找时用
	
	public static final String MATERIALS_FORMAT_MATERIAL = "0";//资料形式->资料
	public static final String MATERIALS_FORMAT_MATERIAL_AND_PRACTISE = "1";//资料形式->资料和练习
	
	// Materials表StoreState字段含义
	public static final int MATERIALS_STORE_STATE_WU = 0; // 待上传
	public static final int MATERIALS_STORE_STATE_UI = 1; // 上传中
	public static final int MATERIALS_STORE_STATE_US = 2; // 上传成功
	public static final int MATERIALS_STORE_STATE_UF = 3; // 上传失败
	
	// Materials表StorePoint字段含义
	public static final String MATERIALS_STORE_POINT_GK = "1"; // 够快网盘
	public static final String MATERIALS_STORE_POINT_CC = "2"; // CC视频
	
	//试卷用常量
	public static final int PAPER_CATEGORY_EXAM = 1; // 模考
	public static final int PAPER_CATEGORY_PRACTISE = 2; // 练习
	public static final int PAPER_CATEGORY_TEST = 3; // 测试
	public static final int PAPER_CATEGORY_MATERIALS = 4; // 资料
	//主观辨别
	public static final int SUBJECTIVE_YES = 1; // 主观
	public static final int SUBJECTIVE_NO = 0; // 客观
	
	//试卷用常量
	public static final String PAPER_CATEGORY_EXAM_STR = "模考"; // 模考
	public static final String PAPER_CATEGORY_PRACTISE_STR = "练习"; // 练习
	public static final String PAPER_CATEGORY_TEST_STR = "测试"; // 测试
	public static final String PAPER_CATEGORY_MATERIALS_STR = "资料"; // 资料
	
	//试题用常量
	public static final int QUESTION_CATEGORY_ALL = 0; // 全部
	
	
	public static final int QUESTION_CATEGORY_PRACTISE = 1; // 练习
	public static final int QUESTION_CATEGORY_EXAM = 2; // 模考
	public static final int QUESTION_CATEGORY_TEST = 3; // 测试
	public static final int QUESTION_CATEGORY_MATERIALS = 4; // 资料
	
	//试题用常量
	public static final String QUESTION_CATEGORY_PRACTISE_STR = "练习"; // 练习
	public static final String QUESTION_CATEGORY_EXAM_STR = "模考"; // 模考
	public static final String QUESTION_CATEGORY_TEST_STR = "测试"; // 测试
	public static final String QUESTION_CATEGORY_MATERIALS_STR = "资料"; // 资料
	
	public static final String QUESTION_STR = "试题";
	public static final String QUESTION_TYPE_STR = "questionType";//试题题型
	public static final String QUESTION_SCENE_STR_1 = "questionScene1";//试题场景1
	public static final String QUESTION_SCENE_STR_2 = "questionScene2";//试题场景2
	public static final String QUESTION_SOURCE_STR = "questionSource";//试题出处
	
	public static final String PAPER_TEST_TYPE_STR = "paperTestType"; // Dictionary表中的Type, 试卷的测试类型
	
	//TaskReminder表IsRead是否已读
	public static final Integer TASK_REMINDER_READ = 1; // 已读
	public static final Integer TASK_REMINDER_NO_READ = 0; // 未读
	
	//TaskReminder表IsPushed推送状态
	public static final Integer TASK_REMINDER_PUSH_SUCCESS = 0; // 推送成功
	public static final Integer TASK_REMINDER_PUSH_FAIL = 1; // 推送失败
	
	//UserDevice表中DeviceTokenType字段
	public static final String USER_DEVICE_IPAD = "Ipad"; // Ipad
	public static final String USER_DEVICE_IPHONE = "Iphone"; // Iphone
	public static final String USER_DEVICE_ANDROID = "Android"; // Android
	public static final String USER_DEVICE_ANDROIDPAD = "AndroidPad"; // AndroidPad
	
	//学生消息类型
	public static final String STU_MESSAGE_TYPE_T = "1"; //老师推送消息
	public static final String STU_MESSAGE_TYPE_S = "0"; // 系统消息
	
	//是否对游客公开
	public static final String IS_OPEN_FOR_VISTOR_YES = "1"; //是
	public static final String IS_OPEN_FOR_VISTOR_NO = "0"; // 否
	
	// 课次类型
	public static final Integer LESSON_TYPE_NONE = 0; // 无课次

	public static final Integer LESSON_TYPE_NOW = 1; // 当前有课次

	public static final Integer LESSON_TYPE_RECENTLY = 2; // 当前无课次，有最近四节课
	
	//互动课堂操作类型
	
	public static final Integer ACTIVECLASS_OPT_TYPE_BEGIN = 1; // 开始答题

	public static final Integer ACTIVECLASS_OPT_TYPE_END = 2; // 结束答题
	
	// 是否可用
	public static final Integer IS_ACTIVE_YES = 1; // 可用
	public static final Integer IS_ACTIVE_NO = 0; // 不可用
	
	/**
	 * 分页参数
	 */
	public static final int pageSize=10;
	
	//试卷->来源->全部
	public static final int PAPER_SOURCE_ALL_ROLE_ID = -1;
	
	//QuestionDocumentFiles表FileType类型
	public static final int QUESTION_DOC_FILES_FILETYPE_VIDEO = 1;
	
	//特殊班级标示符
	public static final String[]  SPECIALClASSLIKESTR = {"初级","中级","高级"};
	
	/**
	 * 课堂互动对象在内存中存储课堂与学生的关系
	 */
	//public static Map<String, Map<String, Object>> activeClassInfoApplicationMap = new ConcurrentHashMap<String, Map<String,Object>>();
	
	//正确率统计
	public static final String STUDENT_RATE = "student"; //学生
	public static final String NATIONAL_RATE = "national"; // 全国
	public static final String GRADE_RATE = "grade"; // 班级
	//labelinfo
	public static final String LABEL_ITEM_TYPES = "item types";//听力题型
	public static final String LABEL_ITEM_TYPES_YD = "Item Types";//阅读题型

	public static final String LABEL_LANGUAGE_ABILITIES = "language abilities";//能力
	public static final String LABEL_LANGUAGE_ABILITIES_YD = "Language Abilities";//阅读能力
	
	public static final String LABEL_LISTENING_SKILLS = "listening skills";//听力技能
	public static final String LABEL_READING_SKILLS = "reading skills";//阅读技能
	
	public static final int CATEGORYID_TL = 6;//听力
	public static final int CATEGORYID_YD = 8;//阅读
	
	/**
	 * CC视频用户ID、key
	 */
	public static final String CC_ORG_UID = "0500478A073885DA";
	public static final String CC_ORG_API_KEY = "ww2SH3nMacwzqy7SfG7NfFhA0HvTHm0I";
	
	/**
	 * 课堂分组状态
	 */
	public static final String ACTIVE_CLASS_GORUP_STATE_I = "0"; //正在分组
	public static final String ACTIVE_CLASS_GORUP_STATE_F = "1"; //完成分组
	
	/**
	 * 课堂分组规则
	 */
	public static final String ACTIVE_CLASS_GORUP_MODE_HAND = "0"; //手动分组
	public static final String ACTIVE_CLASS_GORUP_MODE_AUTO = "1"; //随机分组
	
	/**
	 * 聊天室群组状态
	 */
	public static final String CHATTINGROOM_STATUS_USE = "1"; //可用
	public static final String CHATTINGROOM_STATUS_NO_USE = "0"; //不可用
	
	/**
	 * ScheduleTask表status
	 */
	public static final String SCHEDULETASK_STATUS_USE = "1"; //正在使用
	public static final String SCHEDULETASK_STATUS_NOUSE = "0"; //未使用
	
	//融云KEY、SECRET
	public static final String RONG_CLOUD_KEY = OAuthAppConfig.getString("rongCloudKey");
	public static final String RONG_CLOUD_SECRET = OAuthAppConfig.getString("rongyCloudSecret");
	public static final String SESSION_USER="userId";
	/**
	 * Question type
	 */
	public enum QUESTION_TYPE{
		/**
		 * 阅读文章
		 */
		readContent("3"),
		/**
		 * 视频
		 */
		videos("2");
		
		private String code;
		private QUESTION_TYPE(String code){
			this.code = code;
		}
		@Override
		public String toString(){
			return String.valueOf(this.code);
		}
	}
	
	/**
	 * QuestionScore试题得分点表,字段得分点类型QSType枚举
	 */
	public enum QuestionScore_QSType{
		/**
		 * 1 选择题1
		 */
		SELECTQUESTION1("1"),
		/**
		 * 2 选择题2
		 */
		SELECTQUESTION2("2"),
		/**
		 * 3 选择题3
		 */
		SELECTQUESTION3("3"),
		/**
		 * 4 填空题
		 */
		FILLQUESTION("4"),
		/**
		 * 5 写作题
		 */
		WRITTINGQUESTION("5"),
		/**
		 * 6 口语题
		 */
		ORALQUESTION("6"),
		/**
		 * 7 多项选择
		 */
		MORESELECTQUES("7"),
		/**
		 * 8 多填空组合
		 */
		MOREFILLQUES("8"),
		/**
		 * 9 下拉选择
		 */
		COMSELECTQUES("9");
		
		private String code;
		private QuestionScore_QSType(String code){
			this.code = code;
		}
		@Override
		public String toString(){
			return String.valueOf(this.code);
		}
		
		public Integer toInteger(){
			return Integer.parseInt(this.code);
		}
	}
	
	/**
	 * QuestionScore试题得分点表,字段(单得分点)答案是否可互换CanExchange枚举
	 */
	public enum QuestionScore_CanExchange{
		/**
		 * 1 可互换
		 */
		YES("1"),
		/**
		 * 0 不可互换
		 */
		NO("0");
		
		private String code;
		private QuestionScore_CanExchange(String code){
			this.code = code;
		}
		@Override
		public String toString(){
			return String.valueOf(this.code);
		}
	}
	
	/**
	 * QuestionDocument试题辅助材料表,类型DocType枚举
	 */
	public enum QuestionDocument_DocType{
		/**
		 * 1 听力材料
		 */
		LISTENING("1"),
		/**
		 * 2 试题解析
		 */
		QUESTIONANALYSIS("2"),
		/**
		 * 3 写作范文
		 */
		WRITTING("3");
		
		private String code;
		private QuestionDocument_DocType(String code){
			this.code = code;
		}
		@Override
		public String toString(){
			return String.valueOf(this.code);
		}
	}
	
	public enum ActiveClassVoteDefine_Status {
		/**
		 * ActiveClassVoteDefine表Status字段含义 1开始
		 */
		BEGIN("1"),

		/**
		 * ActiveClassVoteDefine表Status字段含义 10结束
		 */
		END("10");

		private String code;

		private ActiveClassVoteDefine_Status(String code) {
			this.code = code;
		}

		@Override
		public String toString() {
			return String.valueOf(this.code);
		}
	}
	
	public enum ProjectType{
		/**
		 *雅思
		 */
		IELTS("1515"),

		/**
		 * 托福
		 */
		TOFEL("0101"),

		/**
		 * SAT
		 */
		SAT("0145"),
		/**
		 *GRE
		 */
		GRE("0103"),
		/**
		 *GMAT
		 */
		GMAT("0102"),
		/**
		 *ACT
		 */
		ACT("0124"),
		/**
		 *SAT2
		 */
		SAT2("0109");
		private String code;

		private ProjectType(String code) {
			this.code = code;
		}

		@Override
		public String toString() {
			return String.valueOf(this.code);
		}
	}
	
	/**
	 * 日志字段访问类型
	 */
	public static final String PCACCESS = "PC";
	public static final String MOBILEACCESS = "MOBILE";

	//微信用的
	public static  final String APPID  =  OAuthAppConfig.getString("APPID").trim();
	public static  final String  SECRET  = OAuthAppConfig.getString("SECRET").trim();
	public static  final String  WEIXIN_WORD_AUDIO_FILE_FOLDER  = OAuthAppConfig.getString("WEIXIN_WORD_AUDIO_FILE_FOLDER");
	public static final  String  WEIXIN_WORD_AUDIO_FILE_URL = OAuthAppConfig.getString("WEIXIN_WORD_AUDIO_FILE_URL");
	// DateTypeID为TargetDateType主键
	public static final int DATETYPE_EXAM=1; //考试
	public static final int DATETYPE_LX=2; //留学
	//question类型
	public static final int QTYPE_XZ = 300; //口语写作
	//父类标签标示
	public static final int PARENTID = 0; //父类标签的父类为0
	
	//labelinfo 分类标示
	public static final int LABELINFO_XS = 1025; //学术
	public static final int LABELINFO_SH = 1024;//生活
	public static final int LABELINFO_CC = 104; //出处
	public static final int LABELINFO_BJ = 103; //背景
	public static final int LABELINFO_TW = 141; //提问方式
	public static final int LABELINFO_HT = 142; //话题
	public static final int LABELINFO_TM = 82; //题目
	public static final int LABELINFO_TX = 171; //题型
	public static final int LABELINFO_TOEFL_HT = 1149; //话题
	
	//是否为得分点标签
	public static final int QuestionScore_YES=1; //得分点
	public static final int QuestionScore_NO=0;  //非得分点
	//固定标题
	public static final String TEACHERTITLE = "教师提醒";
	public static final String ALLUNITUSE = "不限单元";
	public static final String DIC_TYPE_PROJECT = "projectCode";
	public static int NULLUNITID=0;
	
	//Dic中广告分类的code
	public static final String DIC_ADV_STU="1002";//学生广告
	public static final String DIC_ADV_TEA="1001";//教师广告
	public static final String DIC_ADV_PRE="1003";//预测广告.
	public static final String DIC_ADV_APP="1004";//APP广告.
	public static final String DIC_ADV_OPEN="1005";//公开课广告.
	//入学测试标签字段值 2068 SACT 项目 新加的  GMAT 6005  GRE  5005 ACT 7006
	public static final Integer[] ENTRANCE_EXAM={3102,66,36,2068,6005,5005,7006};
	//APP 日历提醒 相关字段
	public static final String IELTSFILETYPE="1"; //1是文本，2是视频
	public static final String TOEFLFILETYPE="1"; //1是文本，2是视频
	public static final String SATFILETYPE="1"; //1是文本，2是视频
	public static final int IELTSVIDEOID=2852;  //视频ID
	public static final int TOEFLVIDEOID=2852;  //视频ID
	public static final int SATVIDEOID=2852;  //视频ID
	public static final String TdsApiUrl = OAuthAppConfig.getString("TDS_API_URL");
	public static final String TdsAppId = OAuthAppConfig.getString("TDS_APP_ID");
	public static final String TdsAppKey = OAuthAppConfig.getString("TDS_APP_KEY");; ;
	
	//91接口
	public static String JIUYI_URL = OAuthAppConfig.getString("JIUYI_URL");
	public static String JIUYI_CLIENT_ID = OAuthAppConfig.getString("JIUYI_CLIENT_ID");
	public static String JIUYI_SECRET = OAuthAppConfig.getString("JIUYI_SECRET");
	public static String SOURCE_91 = "2";
	
	
	
	//发送邮件相关字段
	public static String SMTP = OAuthAppConfig.getString("SMTP");
	public static String USERNAME = OAuthAppConfig.getString("USERNAME");
	public static String PASSWORD = OAuthAppConfig.getString("PASSWORD");
	
	//学员在开课当天是否第一次进入聊天室
	public static String ZERO = "0";
	public static String FIRST = "1";
	public static String SECOND = "2";
	
	// 班级评语类型
	//SCORE分数：ABCD
	// comment1 评语维度(上次课作业完成情况)
	// comment2 评语维度(本次课学习内容)
	// comment3 评语维度(本次课课堂表现)
	// comment4 评语维度(本次课作业)
	public final static int COMMENTTYPESCORE = 1;
	public final static int COMMENTTYPE1 = 2;
	public final static int COMMENTTYPE2 = 3;
	public final static int COMMENTTYPE3 = 4;
	public final static int COMMENTTYPE4 = 5;
	
	//是否班级评语
	public static final String ISCLASSCOMMENT="1"; //
	//托福模考编辑器类型
	public static final int ST_RICH_TEXT=1; //富文本
	public static final int ST_TEXT_SELECT=2; //文本选择题
	public static final int ST_SENTENCE_ORDER=30; //句子排序题
	public static final int ST_TABLE_RADIO=31; //表格单选题
	public static final int ST_SPOKEN=4; //口语题
	public static final int ST_WRITE=5; //写作题
	public static final int ST_SENTENCE_INSERT=6; //句子插入题
	public static final int ST_SENTENCE_DRAG53=7; //句子拖拽题5+3
	public static final int ST_SENTENCE_DRAG732=8; //句子拖拽题7+3+2
	public static final int ST_WRITE_QUESTION_SPOKEN=9; //写作试题听力音频
	//试题项
	public static final int TEXTPARSING = 1;//文字解析
	public static final int VIDEOPARSING = 2;//视频解析
	public static final int READARTICLE = 3;//阅读文章
	public static final int ARTICLETRANSLATION = 4;//文章译文
	public static final int AUDIO= 5;//听力音频
	public static final int LISTENING = 6;//听力原文
	public static final int GHOST = 7;//口语范文
	public static final int WRITE = 8;//写作范文
	
	//quesitonPagefile的附件类别
	public static final int FJ_YP=1;//音频
	public static final int FJ_TP=2;//图片
	
	//quesitonPagefile的附件层级
	public static final int FJ_LEVEL1=1;//一级
    public static final int FJ_LEVEL2=2;//二级
    public static final int FJ_LEVEL3=3;//三级
	
	public static final int Q_KY = 114;//试题类型 口语
	public static final int Q_XZ = 115;//试题类型 写作
	
	//托福模考 sectionTYpe
	public static final int SECTION_TYPE_LISTEN=1;
	public static final int SECTION_TYPE_SPEAK=2;
	public static final int SECTION_TYPE_READ=3;
	public static final int SECTION_TYPE_WRITE=4;
	
	//托福模考 写作试题类型
	public static final int MULTIPLE_TYPE_WRITE=1409;//综合
	public static final int INDEPENDENT_TYPE_WRITE=1410;//独立
	
	//托福模考批改
	public static final String RATING="RATING";
	
	//国际课程辅导在线（65）
	public static final String OPEN_CLASS = "65";
	
	public enum Question_TOEFL_Qthem{
		/**
		 * toefl试题类型 推送状态： 1听力
		 */
		TL(1),
		/**
		 * toefl试题类型 推送状态： 2阅读
		 */
		YD(2),
		/**
		 * toefl试题类型 推送状态： 3写作
		 */
		XZ(3),
		/**
		 * toefl试题类型 推送状态： 4口语
		 */
		KY(4);
		
		private int code;
		private Question_TOEFL_Qthem(int code){
			this.code = code;
		}
		@Override
		public String toString(){
			return String.valueOf(this.code);
		}
		public Integer toInteger(){
			return Integer.valueOf(this.code);
		}
	}
	
	//已成和未成用户的表示字段
	public static final int NOT_USER=0;//未成
	public static final int USED_USER=1;//已成
	
	
	//SAT模考 sectionTYpe
	public static final int SAT_SECTION_TYPE_READ=1;
	public static final int SAT_SECTION_TYPE_WF=2;
	public static final int SAT_SECTION_TYPE_MATH_NC=3;
	public static final int SAT_SECTION_TYPE_MATH=4;
	public static final int SAT_SECTION_TYPE_WRITE=5;

	public static final int SAT_KM_TYPE_READ = 2434;
	public static final int SAT_KM_TYPE_WF = 2435;
	public static final int SAT_KM_TYPE_MATH = 2436;
	
	//SAT模考试卷模块
	public static final String SAT_MK_YD = "阅读";
	public static final String SAT_MK_WF = "文法";
	public static final String SAT_MK_SX = "数学";
	public static final String SAT_MK_SX1 = "数学1";
	public static final String SAT_MK_SX2 = "数学2";
	public static final String SAT_MK_XZ = "写作";
	
	//SAT模考试卷模块得分点
	public static final int SAT_MK_YD_SP = 52;
	public static final int SAT_MK_WF_SP = 44;
	public static final int SAT_MK_SX1_SP = 20;
	public static final int SAT_MK_SX2_SP = 38;
	public static final int SAT_MK_XZ_SP = 1;
	//MDM url
	public static String MDM_URL = OAuthAppConfig.getString("MDM_URL");
	public static String MDM_URL_NEW = OAuthAppConfig.getString("MDM_URL_NEW");
	public static String MDM_APP_ID = OAuthAppConfig.getString("MDM_APP_ID");
	public static String MDM_APP_SECRET = OAuthAppConfig.getString("MDM_APP_SECRET");
	
	//反馈附件 fileType 附件类型 1图片 2 音频
	public static final String FEEDBACK_FILE_TYPE_PICTURE = "1";
	public static final String FEEDBACK_FILE_TYPE_AUDIO = "2";
	
	//反馈附件 关联类型 1班级反馈 2 学生反馈
	public static final String FEEDBACK_CONTACT_TYPE_CLASS = "1";
	public static final String FEEDBACK_CONTACT_TYPE_STUDENT = "2";
	
	//反馈附件 反馈类型 2  授课内容 2 班级学情反馈  3 本次课课后作业 4 随堂测点评  5 本次课授课内容 (1,2,3 为班级反馈使用   4,5为学生反馈使用)
	public static final String FEEDBACK_TYPE_REVIEWLESSON_CLASS = "1";//班级学情反馈
	public static final String FEEDBACK_TYPE_THISLECTURECONTENT_CLASS = "2";//授课内容
	public static final String FEEDBACK_TYPE_THISHOMEWORK_CLASS = "3";//课后作业
	public static final String FEEDBACK_TYPE_CLASSPERFORMANCE_STUDENT = "4";
	public static final String FEEDBACK_TYPE_STUDYANALYSIS_STUDENT = "5";

	//出勤情况：1旷课 2请假 3迟到 4正常 5早退 Attendance
	public static final String ATTENDANCE_ABSENTEEISM = "1";
	public static final String ATTENDANCE_LEAVE = "2";
	public static final String ATTENDANCE_LATE = "3";
	public static final String ATTENDANCE_NORMAL = "4";
	public static final String ATTENDANCE_LEAVEEARLY = "5";

	//出勤情况：0参加1旷课2请假3迟到4无需参加5其他 Directory 表 absenceType
	public static final int ABSENCETYPE_ATTEND = 0;
	public static final int ABSENCETYPE_ABSENTEEISM = 1;
	public static final int ABSENCETYPE_LEAVE = 2;
	public static final int ABSENCETYPE_LATE = 3;
	public static final int ABSENCETYPE_NOATTEND = 4;
	public static final int ABSENCETYPEA_OTHER = 5;

	//midwkTest 1随堂测2周中测3留堂测
	public static final int MIDWKTEST_ONCLASS = 1;
	public static final int MIDWKTEST_WEEK = 2;
	public static final int MIDWKTEST_LIVECLASS= 3;


	//收手机 ： 1拒交 2没带 3充电 4上交
	public static final String RECPHONE_REFUSE = "1";
	public static final String RECPHONE_WITHOUT = "2";
	public static final String RECPHONE_CHARGE = "3";
	public static final String RECPHONE_SHANGJIAO = "4";
	
	//收手机状态：1开 2关
	public static final String DELIVERY_OPEN = "1";
	public static final String DELIVERY_CLOSE = "2";
	
	//MDM获取学员基本信息以及报班信息
	public static String STUDENT_CLASSES = "/1/its/student/student_classes";
	//MDM根据userId和appId 获取登陆个人信息
	public static String MDM_SEARCH_BY_USERID = "/1/student/relation/search_by_userid";
	
	//MDM根据userId和studentName mobilePhone 获取学员号信息和绑定情况
	public static String MDM_SEARCH_SCODE = "/1/student/relation/search_and_check";
	
	
	//MDM回调主数据绑定学员号
	public static String MDM__BIND_SCODE = "/1/student/relation/create";
	
	//自由任务附件类型
	public static int ATTACHMENT_TYPE_PIC = 1;  //图片
	public static int ATTACHMENT_TYPE_AUD = 2;  //音频

	//课次反馈表关联类型
	public static String FEECBACK_CONTACT_CLASS = "1";  //班级
	public static String FEECBACK_CONTACT_STUDENT = "2";  //学员
	
	//教师端 任务作业 发布人
	public static String TASK_PUBLISHER_All = "0";  //全部
	public static String TASK_PUBLISHER_OWN = "1";  //自己
	public static String TASK_PUBLISHER_OTHER = "2";  //其他人
	
	//是否勾选
	public static final String CHECH_NO = "0";   //未勾选
	public static final String CHECH_YES = "1";  //勾选
	
	public static final int SECRECY_NO = 0;   //公开
	public static final int SECRECY_YES = 1;  //保密
	public static final int SECRECY_ALL = 2;  //全部 (查询用)

	//新托福分班测试类型
	public static final Integer[] NEWTOWFL_KM={127,128,153,154};
	public static final int NEWTOWFL_TYPE=155;
	public static final int NEWTOWFL_KM_SPEECH=153;//语音
	public static final int INDEPENDENT_KM_WORD=127;//词汇
	public static final int INDEPENDENT_KM_GRAMMAR=128;//语法
	public static final int INDEPENDENT_KM_SPELL=154;//拼写
	public static final int PLACEMENT_TEST=143;//分班测试类型
	
	
	//新加入班测试
	public static final int LABELINFO_ENTRANCE_YY1 = 1534; //听音辨音
	public static final int LABELINFO_ENTRANCE_YY2 = 1535; //听句理解
	public static final int LABELINFO_ENTRANCE_YY3 = 1536; //听句填空
	public static final int LABELINFO_ENTRANCE_CH1 = 1525; //基础词汇
	public static final int LABELINFO_ENTRANCE_CH2 = 1526; //进阶词汇
	public static final int LABELINFO_ENTRANCE_CH3 = 1527; //核心词汇
	public static final int LABELINFO_ENTRANCE_CH4 = 1528; //学科学术词汇
	public static final int LABELINFO_ENTRANCE_YF1 = 1530; //词法
	public static final int LABELINFO_ENTRANCE_YF2 = 1531; //句法
	public static final int LABELINFO_ENTRANCE_YF3 = 1532; //长难句分析

	public static final String VISITOR_FLAG_TURE = "1"; //游客标示
	
	public static final int  SYSTEM_PC = 1; //pc 端
	public static final int  SYSTEM_APP = 2; //app 端
	
}
