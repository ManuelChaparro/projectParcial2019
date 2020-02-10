package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;

public class Utilities {	
	
	public static InputStream getHttpURLConnection(boolean isProxy, String urlFile) {
		HttpURLConnection httpURLConnection;
		URL url = null;
		InputStream inputStream = null;
		try {
			url = new URL( urlFile );
			if ( !isProxy ) {
				System.out.println("Downloading data without proxy");
				httpURLConnection = (HttpURLConnection) url.openConnection();	
				inputStream = httpURLConnection.getInputStream();
			}else {
				//Para funcionamiento dentro de la universidad
				System.out.println("Cannot connect");
				System.out.println("Downloading data with proxy");
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080));
				httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
				inputStream = httpURLConnection.getInputStream();
				if(inputStream == null )
					System.out.println( "Este input no quiere funcionar" );
			}

		}catch(ConnectException connectException) {
			isProxy = true;
			return getHttpURLConnection( isProxy, urlFile );
		} catch (UnknownHostException e) {
			isProxy = true;
			System.out.println( "Catch: " + e.getMessage()  );
			return getHttpURLConnection( isProxy, urlFile );
		} catch (MalformedURLException e1) {
			System.out.println(  e1.getMessage()  );
		}catch (IOException e) {
			System.out.println(  e.getMessage()  );
		}
//		System.out.println(inputStream);
		
		return inputStream;
	}
	
	public static void writeFile(String pathLocalFile, String urlFile) throws IOException {
		InputStream in = getHttpURLConnection(false, urlFile);
		@SuppressWarnings("resource")
		FileOutputStream out = new FileOutputStream(pathLocalFile);
		int c;
		while ((c = in.read()) != -1) {
			out.write(c);	
		}
	}
	
}
