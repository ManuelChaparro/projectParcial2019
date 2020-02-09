package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.ObjectInputStream.GetField;

public class Constants {
	
	private static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	
	//Constants for text
	
	public static final String WRITING_BLACKBERRY = "Writing data blackberry";
	public static final String WRITING_STRAWBERRY = "Writing data strawberry";
	public static final String WRITING_LULO = "Writing data lulo";
	public static final String WRITING_BANANA = "Writing data banana";
	public static final String WRITING_PASSION_FRUIT = "Writing data passion fruit";
	public static final String WRITING_PEACH = "Writing data peach";
	
	public static final String TITLE_WINDOW = "FRUIT_REGISTER";
	public static final String TITLE_DIALOG_NEW = "NEW_FILE";
	public static final String TITLE_DIALOG_GRAPHIC = "GRAPHIC";
	public static final String TITLE_ADD_NEW_CHAIN = "ADD_NEW_CHAIN";
	public static final String TITLE_DELETE_CHAIN = "DELETE_CHAIN";
	
	public static final String BUTTON_HOME = "BUTTON_HOME";
	public static final String BUTTON_EXPORT = "BUTTON_EXPORT";
	public static final String BUTTON_GRAPHICS = "BUTTON_GRAPHICS";
	
	public static final String OPTION_FILE = "FILE";
	public static final String OPTION_FILE_ADD_FRUIT = "ADD_INFO_FRUIT";
	public static final String OPTION_FILE_SHOW_GRAPHIC = "SHOW_GRAPHIC";
	public static final String OPTION_DELETE_ITEM = "DELETE_ITEM";
	public static final String OPTION_FILE_READ_FILE = "READ_LOCAL_FILE";
	public static final String OPTION_CHANGE_LANGUAGE = "CHANGE_LENGUAGE";
	public static final String OPTION_CHANGE_FRUIT = "CHANGE_FRUIT";
	public static final String OPTION_CHANGE_L_SPANISH = "CHANGE_L_SPANISH";
	public static final String OPTION_CHANGE_L_ENGLISH = "CHANGE_L_ENGLISH";
	public static final String OPTION_CHANGE_BANANA = "CHANGE_BANANA_ITEM";
	public static final String OPTION_CHANGE_BLACKBERRY = "CHANGE_BLACKBERRY_ITEM";
	public static final String OPTION_CHANGE_LULO = "CHANGE_LULO_ITEM";
	public static final String OPTION_CHANGE_PASSION_FRUIT= "CHANGE_PASSION_FRUIT_ITEM";
	public static final String OPTION_CHANGE_PEACH = "CHANGE_PEACH_ITEM";
	public static final String OPTION_CHANGE_STRAWBERRY = "CHANGE_STRAWBERRY_ITEM";
	
	
	public static final String TO = "TO";
	public static final String NAME = "NAME";
	public static final String DEPARTMENT = "DEPARTMENT";
	public static final String ID_TOWN = "ID_TOWN";
	public static final String TOWN = "TOWN";
	public static final String GENDER = "GENDER";
	public static final String AGE_GROUP = "AGE_GROUP";
	public static final String SISBEN_SCORE = "SISBEN_SCORE";
	public static final String BENEFICIARIES = "BENEFICIARIES";
	public static final String INVESTMENT = "INVESTMENT";
	public static final String HECTARE = "HECTARE";
	
	public static final String STATE_FRUIT_EXCELENT = "FRESH_FRUIT";
	public static final String STATE_FRUIT_BAD = "BAD_FRUIT";
	
	
	public static final String FOOTER_COUNTRY = "FOOTER_COUNTRY";
	public static final String FOOTER_CELLPHONE = "FOOTER_CELLPHONE";
	public static final String FOOTER_ABOUT_US = "FOOTER_ABOUT_US";


	public static final String NOTICE_DELETE_FILE = "DELETE_FILE";
	
	
	
	//Headers for table
	public static final String H_NAME= "H_NAME";
	public static final String H_DEPARTMENT= "H_DEPARTMENT";
	public static final String H_TOWN= "H_TOWN";
	public static final String H_ID_TOWN= "H_ID_TOWN";
	public static final String H_GENDER= "H_GENDER";
	public static final String H_AGE_GROUP= "H_AGE_GROUP";
	public static final String H_SISBEN_SCORE = "H_SISBEN_SCORE";
	public static final String H_BENEFICIARIES= "H_BENEFICIARIES";
	public static final String H_INVESTMENT= "H_INVESTMENT";
	public static final String H_HECTARE= "H_HECTARE";
	public static final String WITHOUT_SCORE = "SIN PUNTAJE";
	
	//Constants for Errors
	public static final String FILE_NOT_FOUND = "ERROR_NAME_FILE_CONFIG";
	public static final String ERROR_BY_ZERO = "ERROR_BY_ZERO";
	public static final String ERROR_TO_INT = "ERROR_TO_INT";
	public static final String ERROR_AREA = "ERROR_AREA";
	public static final String ERROR_STRING = "ERROR_STRING";
	public static final String ERROR_URL_FILE = "tThe url does not exist or is not accessible";
	
	//Constants for paths
	public static final String PATH_IMAGE_BANNER = "/resource/banner.png";
	public static final String PATH_IMAGE_HOME = "/resource/homeImage.jpg";
	public static final String PATH_ICON_FRAME = "/resource/iconFrame.png";
	public static final String PATH_ICON_ACCEPT = "/resource/iconAccept.png";
	public static final String PATH_ICON_CANCEL = "/resource/iconCancel.png";
	public static final String PATH_ICON_SEARCH = "/resource/iconSearch.png";
	public static final String PATH_LOCAL_FILE_BLACKBERRY = "resource/blackberry.INFO";
	public static final String PATH_LOCAL_FILE_STRAWBERRY = "resource/strawberry.INFO";
	public static final String PATH_LOCAL_FILE_LULO = "resource/lulo.INFO";
	public static final String PATH_LOCAL_FILE_BANANA = "resource/banana.INFO";
	public static final String PATH_LOCAL_FILE_PASSION_FRUIT = "resource/passion_fruit.INFO";
	public static final String PATH_LOCAL_FILE_PEACH = "resource/peach.INFO";
	public static final String PATH_IMAGE_BLACKBERRY = "/resource/iconBlackberry.png";
	public static final String PATH_IMAGE_STRAWBERRY = "/resource/iconStrawberry.png";
	public static final String PATH_IMAGE_LULO = "/resource/iconLulo.png";
	public static final String PATH_IMAGE_BANANA = "/resource/iconBanana.png";
	public static final String PATH_IMAGE_PASSION_FRUIT = "/resource/iconPassionFruit.png";
	public static final String PATH_IMAGE_PEACH = "/resource/iconPeach.png";

	public static final String PATH_URL_FILE_BLACKBERRY = "https://www.datos.gov.co/api/views/5sr3-8337/rows.json?accessType=DOWNLOAD";
	public static final String PATH_URL_FILE_STRAWBERRY = "https://www.datos.gov.co/api/views/8yeg-vys5/rows.json?accessType=DOWNLOAD";
	public static final String PATH_URL_FILE_LULO = "https://www.datos.gov.co/api/views/wqdv-y78j/rows.json?accessType=DOWNLOAD";
	public static final String PATH_URL_FILE_BANANA = "https://www.datos.gov.co/api/views/66u3-7nne/rows.json?accessType=DOWNLOAD";
	public static final String PATH_URL_FILE_PASSION_FRUIT = "https://www.datos.gov.co/api/views/cjjs-6r5i/rows.json?accessType=DOWNLOAD";
	public static final String PATH_URL_FILE_PEACH = "https://www.datos.gov.co/api/views/7xnk-585m/rows.json?accessType=DOWNLOAD";
	public static final String NAME_FILE_CONFIG = "config.init";
	
	public static final String PATH_HAN_LEN_SPANISH = "language/language_spanish.properties";
	public static final String PATH_HAN_LEN_ENGLISH = "language/language_english.properties";
	
	//Constants for numbers
	public static final int M_WIDTH_SIZE = (int) (dimension.getWidth()*0.93);
	public static final int M_HEIGHT_SIZE = (int) (dimension.getHeight()*0.7);
	public static final int WIDTH = (int) (dimension.getWidth());
	public static final int HEIGTH = (int) (dimension.getHeight());
	
	public static final double PERCENTAGE_WIDTH = 0.8;
	
	
	//Constants for Fonts
	private static final int DEFAULT_FONT_SIZE = (int) (dimension.getHeight()*0.021);
	private static final int DEFAULT_FONT_MAX_SIZE = (int) (dimension.getHeight()*0.024);
	private static final int DEFAULT_FONT_MIN_SIZE = (int) (dimension.getHeight()*0.02);
	public static final Font DEFAULT_FONT = new Font("Segoe UI", Font.BOLD, DEFAULT_FONT_SIZE);
	public static final Font DEFAULT_FONT_MAX = new Font("Segoe UI", Font.BOLD, DEFAULT_FONT_MAX_SIZE);
	public static final Font DEFAULT_FONT_MIN = new Font("Segoe UI", Font.BOLD, DEFAULT_FONT_MIN_SIZE);

	//Constants for Colors
	public static final Color DEFAULT_COLOR = Color.decode("#008000");
	public static final Color AQUA_COLOR = Color.decode("#009D71");
	public static final Color RED_COLOR = Color.decode("#CB1D11");
	
	//Constants for Fruits
	public static final String STRAWBERRY = "FRESA";
	public static final String BLACKBERRY = "MORA";
	public static final String BANANA = "PLÁTANO";
	public static final String LULO = "LULO";
	public static final String PASSION_FRUIT = "MARACUYÁ";
	public static final String PEACH = "DURAZNO";
	
	//Constants for Gender
	public static final String WOMAN = "MUJER";
	public static final String MALE = "HOMBRE";
	
	//Constants for Departments
	public static final String AMAZONAS = "AMAZONAS";
	public static final String ANTIOQUIA = "ANTIOQUIA";
	public static final String ARAUCA = "ARAUCA";
	public static final String ATLANTICO = "ATLANTICO";
	public static final String BOGOTA_DC = "BOGOTA DC";
	public static final String BOLIVAR = "BOLIVAR";
	public static final String BOYACA = "BOYACA";
	public static final String CALDAS = "CALDAS";
	public static final String CAQUETA = "CAQUETA";
	public static final String CASANARE = "CASANARE";
	public static final String CAUCA = "CAUCA";
	public static final String CESAR = "CESAR";
	public static final String CHOCO = "CHOCO";
	public static final String CORDOBA = "CORDOBA";
	public static final String CUNDINAMARCA = "CUNDINAMARCA";
	public static final String GUAINIA = "GUAINIA";
	public static final String GUAVIARE = "GUAVIARE";
	public static final String HUILA = "HUILA";
	public static final String LA_GUAJIRA = "LA GUAJIRA";
	public static final String MAGDALENA = "MAGDALENA";
	public static final String META = "META";
	public static final String NARINO = "NARI�O";
	public static final String NORTE_DE_SANTANDER = "NORTE DE SANTANDER";
	public static final String PUTUMAYO = "PUTUMAYO";
	public static final String QUNIDIO = "QUNIDIO";
	public static final String RISARALDA = "RISARALDA";
	public static final String SAN_ANDRES = "SAN ANDRES";
	public static final String SANTANDER = "SANTANDER";
	public static final String SUCRE = "SUCRE";
	public static final String TOLIMA = "TOLIMA";
	public static final String VALLE_DEL_CAUCA = "VALLE DEL CAUCA";
	public static final String VAUPES = "VAUPES";
	public static final String VICHADA = "VICHADA";
	
	public static final String ID_AMAZONAS = "91";
	public static final String ID_ANTIOQUIA = "05";
	public static final String ID_ARAUCA = "81";
	public static final String ID_ATLANTICO = "08";
	public static final String ID_BOGOTA_DC = "11";
	public static final String ID_BOLIVAR = "13";
	public static final String ID_BOYACA = "15";
	public static final String ID_CALDAS = "17";
	public static final String ID_CAQUETA = "18";
	public static final String ID_CASANARE = "85";
	public static final String ID_CAUCA = "19";
	public static final String ID_CESAR = "20";
	public static final String ID_CHOCO = "27";
	public static final String ID_CORDOBA = "23";
	public static final String ID_CUNDINAMARCA = "25";
	public static final String ID_GUAINIA = "94";
	public static final String ID_GUAVIARE = "95";
	public static final String ID_HUILA = "41";
	public static final String ID_LA_GUAJIRA = "44";
	public static final String ID_MAGDALENA = "47";
	public static final String ID_META = "50";
	public static final String ID_NARINO = "52";
	public static final String ID_NORTE_DE_SANTANDER = "54";
	public static final String ID_PUTUMAYO = "86";
	public static final String ID_QUNIDIO = "63";
	public static final String ID_RISARALDA = "66";
	public static final String ID_SAN_ANDRES = "88";
	public static final String ID_SANTANDER = "68";
	public static final String ID_SUCRE = "70";
	public static final String ID_TOLIMA = "73";
	public static final String ID_VALLE_DEL_CAUCA = "76";
	public static final String ID_VAUPES = "97";
	public static final String ID_VICHADA = "99";

}
