package xyz.eden.learn.algorithm.ds.hugedata;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/14 16:00
 */
public class BitMapDemo {

    public static void main(String[] args) {

    }

    class BitMap {
        private static final int SEGMENT_SIZE = 16;
        private static final int SEGMENT_MASK = 65535;
        private Map<Long, BitSet> bitSegments = new HashMap();

        public BitMap() {
        }

        public void set(long index) throws IndexOutOfBoundsException {
            if (index < 0L) {
                throw new IndexOutOfBoundsException(index + " is negative.");
            } else {
                BitSet bitset = this.getBitSet(index, true);
                if (bitset == null) {
                    throw new IndexOutOfBoundsException(index + " is out of bounds");
                } else {
                    int useIndex = this.getIntIndex(index);
                    bitset.set(useIndex);
                }
            }
        }

        public boolean get(long index) throws IndexOutOfBoundsException {
            if (index < 0L) {
                throw new IndexOutOfBoundsException(index + " is negative.");
            } else {
                BitSet bitset = this.getBitSet(index, false);
                if (bitset == null) {
                    return false;
                } else {
                    int useIndex = this.getIntIndex(index);
                    return bitset.get(useIndex);
                }
            }
        }

        private BitSet getBitSet(long index, boolean allowCreate) {
            Long segmentId = Long.valueOf(index >> 16);
            BitSet bitset = this.bitSegments.get(segmentId);
            if (allowCreate && bitset == null) {
                bitset = new BitSet();
                this.bitSegments.put(segmentId, bitset);
            }

            return bitset;
        }

        private int getIntIndex(long index) {
            return (int) (index & 65535L);
        }

        int getNumSegments() {
            return this.bitSegments.size();
        }

        int cardinality() {
            int count = 0;

            BitSet b;
            for (Iterator iter = this.bitSegments.values().iterator(); iter.hasNext(); count += b.cardinality()) {
                b = (BitSet) iter.next();
            }

            return count;
        }
    }

}
