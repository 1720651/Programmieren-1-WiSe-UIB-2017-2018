package uebungen.beispiele;

public class SHA1Hash {

	public static void main(String[] args) {
		System.out.println(hash("Hallo!")); 			// f02a27e2f102fa7505d94fafb494b40875dec5b6
		//		System.out.println(hash("A Test")); 			// 8f0c0855915633e4a7de19468b3874c8901df043
		//				System.out.println(hash("jhztrew2134567865sdfsdfsdfsdfdsfsdfsdn 555555555 12345x")); 	// bf1e7071dd9ffd2f38f42bfa2783fe112697b767
		//	System.out.println(hash("jhztrew2134567865sdfsdfsdfsdfdsfsdfsdn 555555555 12345xx")); 	// c772f21cba943d6c2ec491577fd31cc4c8ad84cc
		//		System.out.println(hash("jhztrew2134567865sdfsdfsdfsdfdsfsdfsdn 555555555 12345xxxxxxxxxx")); 	// f72bae477a759087d188becf241aa1295b633577
		//		System.out.println(hash("hallo!")); 
	}

	private static byte[][] makeBlocks(String in) {
		int noOfBlocks = (in.length() + 1 + 8) / 64 
				+ ((in.length() + 1 + 8) % 64 == 0? 0 : 1);
		byte[][] blocks = new byte[noOfBlocks][64];

		int i = 0;
		for (; i < in.length(); i++) {
			blocks[i/64][i%64] = (byte) in.charAt(i);
		}

		blocks[i/64][(i%64)] = ((byte) 0x80);

		long length = in.length() * 8;
		for (int j = 0; j < 8; j++) {
			blocks[blocks.length-1][56 + j] = (byte) (length >> (56 - (j * 8)));
		}

		return blocks;
	}

	private static int[] byteBlockToIntBlock(byte[] block) {
		int[] res = new int[16];

		for (int i = 0; i < block.length; i += 4) {
			res[i/4] = ((block[i] & 0xFF) << 24) + ((block[i+1] & 0xFF) << 16) 
					+ ((block[i+2] & 0xFF) << 8) + (block[i+3] & 0xFF);
		}

		return res;
	}

	private static int[] makeEightyWords(int[] block) {
		int[] words = new int[80];

		for (int i = 0; i < block.length; i++) {
			words[i] = block[i];
		}

		for (int i = 16; i <= 79; i++) {
			words[i] = Integer.rotateLeft(words[i-3] ^ words[i-8] ^ words[i-14] ^ words[i-16], 1);
		}

		return words;
	}

	private static void mainLoop(byte[] input, int[] h) {
		int[] block = byteBlockToIntBlock(input);
		int[] words = makeEightyWords(block);

		int a = h[0];
		int b = h[1];
		int c = h[2];
		int d = h[3];
		int e = h[4];

		// process the 80 words
		for (int i = 0; i <= 79; i++) {
			int f = 0, k = 0;

			if (i <= 19) {
				f = b & c | ~b & d;
				k = 0x5A827999;
			} else if (i >= 20 && i <= 39) {
				f = b ^ c ^ d;
				k = 0x6ED9EBA1;
			} else if (i >= 40 && i <= 59) {
				f = b & c | b & d | c & d;
				k = 0x8F1BBCDC;
			} else if (i >= 60) {
				f = b ^ c ^ d;
				k = 0xCA62C1D6;
			}

			int temp =  Integer.rotateLeft(a, 5) + f + e + k + words[i];
			e = d;
			d = c;
			c = Integer.rotateLeft(b, 30);
			b = a;
			a = temp;

		}	// for all words

		// use side effect!!!
		h[0] = h[0] + a;
		h[1] = h[1] + b;
		h[2] = h[2] + c;
		h[3] = h[3] + d;
		h[4] = h[4] + e;
	}


	public static String hash(String in) {
		int[] h = {0x67452301, 0xEFCDAB89, 0x98BADCFE, 0x10325476, 0xC3D2E1F0};

		byte[][] blocks = makeBlocks(in);

		for (int b = 0; b < blocks.length; b++) {
			mainLoop(blocks[b], h);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < h.length; i++) {
			String str = String.format("%08x", h[i]); 
			sb.append(str);
		}

		return sb.toString();
	}

}
