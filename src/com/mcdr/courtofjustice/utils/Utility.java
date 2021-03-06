package com.mcdr.courtofjustice.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.mcdr.courtofjustice.CourtOfJustice;


public abstract class Utility {
	public static java.util.Random random = new java.util.Random();
	
	public static int Random(int min, int max) {
		int result = (int) (random.nextDouble() * (max - min + 1) + min);
		return result;
	}
	
	public static boolean isNear(Location first, Location second, int minDistance, int maxDistance) {
		if(first.getWorld()!=second.getWorld())
			return false;
		
		//TODO Square before circle.
		double relX = first.getX() - second.getX();
		double relY = first.getY() - second.getY();
		double relZ = first.getZ() - second.getZ();
		double dist = relX * relX + relY * relY + relZ * relZ;
		
		if (dist < maxDistance * maxDistance && dist > minDistance * minDistance)
			return true;
		
		return false;
	}
	
	public static void setFacing(LivingEntity le, Vector vector) {
        double yaw = Math.toDegrees(Math.atan2(-vector.getX(), vector.getZ()));
        double pitch = Math.toDegrees(-Math.asin(vector.getY()));
                        
        Location loc = le.getLocation();
        loc.setYaw((float)yaw);
        loc.setPitch((float)pitch);
        
        le.teleport(loc);
	}
	
	public static boolean hasPermission(CommandSender sender, String permission){
		if(sender instanceof Player)
			return ((Player) sender).isOp() || hasPermission((Player) sender, permission);
		else
			return true;
	}
	
	public static boolean hasPermission(Player player, String permission){
		return CourtOfJustice.in.pm.hasPermission(player, permission);
	}
	
	public static void streamToFile(InputStream resource, File file) throws Exception {
		OutputStream outputStream = new FileOutputStream(file);
		
		copy(resource, outputStream);
	}
	
	public static void fileToFile(File sourceFile, File destFile) throws IOException {
	    if(!destFile.exists()) {
	        destFile.createNewFile();
	    }
	    FileChannel source = null;
	    FileChannel destination = null;
	    FileInputStream fis = null;
	    FileOutputStream fos = null;
	    try {
	    	fis = new FileInputStream(sourceFile);
		    fos = new FileOutputStream(destFile);
	        source = fis.getChannel();
	        destination = fos.getChannel();

	        // previous code: destination.transferFrom(source, 0, source.size());
	        // to avoid infinite loops, should be:
	        long count = 0;
	        long size = source.size();              
				while((count += destination.transferFrom(source, count, size-count))<size);
	    } finally {
	        if(source != null)
				source.close();
	        if(destination != null)
	            destination.close();
	        if(fis != null)
	        	fis.close();
	        if(fos != null)
	        	fos.close();
	    }
	}
	
	private static void copy(InputStream inputStream, OutputStream outputStream) throws Exception {
		int read = 0;
		byte[] bytes = new byte[1024];
		
		while ((read = inputStream.read(bytes)) != -1)
			outputStream.write(bytes, 0, read);
		
		inputStream.close();
		outputStream.close();
	}
	
	/**
	 * Checks if the first input is an older version number than the second input
	 * @param version1 the version to check
	 * @param version2 the version to check against
	 * @return true if the first input is an older version number, false if it isn't
	 */
	public static boolean isOlderVersion(String version1, String version2) {
		return isNewerVersion(version2, version1);
	}
	
	/**
	 * Checks if the first input is a newer version number than the second input
	 * @param version1 the version to check
	 * @param version2 the version to check against
	 * @return true if the first input is a newer version number, false if it isn't
	 */
	public static boolean isNewerVersion(String version1, String version2) {
        String s1 = normalisedVersion(version1);
        String s2 = normalisedVersion(version2);
        int cmp = s1.compareTo(s2);
        //String cmpStr = cmp < 0 ? "<" : cmp > 0 ? ">" : "==";
        return cmp>0;
    }

	private static String normalisedVersion(String version) {
        return normalisedVersion(version, ".", 4);
    }

	private static String normalisedVersion(String version, String sep, int maxWidth) {
        String[] split = Pattern.compile(sep, Pattern.LITERAL).split(version);
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(String.format("%" + maxWidth + 's', s));
        }
        return sb.toString();
	}
	
	public static String calculateMd5Hash(File f){
		try{MessageDigest digest = MessageDigest.getInstance("MD5");
			InputStream is = new FileInputStream(f);                
			byte[] buffer = new byte[8192];
			int read = 0;
			try {
			    while( (read = is.read(buffer)) > 0) {
			        digest.update(buffer, 0, read);
			    }       
			    byte[] md5sum = digest.digest();
			    BigInteger bigInt = new BigInteger(1, md5sum);
			    String output = bigInt.toString(16);
			    return output;
			} catch(IOException e) {
			    throw new RuntimeException("Unable to process file for MD5", e);
			} finally {
			    try {
			        is.close();
			    }
			    catch(IOException e) {
			        throw new RuntimeException("Unable to close input stream for MD5 calculation", e);
			    }
			}
		} catch(NoSuchAlgorithmException e) {
			throw new RuntimeException("The md5 algorithm doesn't seem to be available on your system", e);
		} catch(FileNotFoundException e) {
			throw new RuntimeException("The file to hash was not found, are you sure you have the right File object?", e);
		}
	}
}
