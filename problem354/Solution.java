class Solution {
    public static class Dot {
		public int w;
		public int h;

		public Dot(int weight, int hight) {
			w = weight;
			h = hight;
		}
	}

	public static class DotComparator implements Comparator<Dot> {
		@Override
		public int compare(Dot arg0, Dot arg1) {
			if (arg0.w != arg1.w) {
				return arg0.w - arg1.w;
			} else {
				return arg1.h - arg0.h;
			}
		}
	}
    
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2) {
			return 0;
		}
		Dot[] dots = new Dot[envelopes.length];
		for (int i = 0; i < envelopes.length; i++) {
			dots[i] = new Dot(envelopes[i][0], envelopes[i][1]);
		}
		Arrays.sort(dots, new DotComparator());
		int[] ends = new int[envelopes.length];
		ends[0] = dots[0].h;
		int right = 0;
		int l = 0;
		int r = 0;
		int m = 0;
		for (int i = 1; i < dots.length; i++) {
			l = 0;
			r = right;
			while (l <= r) {
				m = (l + r) / 2;
				if (dots[i].h > ends[m]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
			right = Math.max(right, l);
			ends[l] = dots[i].h;
		}
		return right + 1;
    }
}
