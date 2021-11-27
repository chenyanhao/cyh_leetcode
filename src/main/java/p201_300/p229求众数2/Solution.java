package p201_300.p229求众数2;

import java.util.ArrayList;
import java.util.List;

/**
 * 超过 n/3 的数最多只有2个，所以思路为：
 * 1）遍历数组，找出数组中，出现次数最多的2个数
 * 2）再次遍历数组，只计数出这2个数出现的次数（为什么需要再次遍历？因为出现最二多的数，其总次数不一定会超过 n/3）
 * 3）判断这2个数出现的次数是否超过 n/3
 *
 * 根据以上思路，上面两次遍历，分别对应摩尔投票法的两个阶段：抵消阶段和计数阶段。
 *
 *
 * 换个思路理解。
 * 有一个对摩尔投票法非常形象的比喻：多方混战。
 * 首先要知道，在任何数组中，出现次数大于该数组长度1/3的值最多只有两个。
 * 把这道题比作一场多方混战，战斗结果一定只有最多两个阵营幸存，其他阵营被歼灭。数组中的数字即代表某士兵所在的阵营。
 * 因此维护两个潜在幸存阵营A和B。遍历数组，如果遇到了属于A或者属于B的士兵，则把士兵加入A或B队伍中，该队伍人数加一。继续遍历。
 * 如果遇到了一个士兵既不属于A阵营，也不属于B阵营，这时有两种情况：
 *  - 情况一：A阵营和B阵营都还有活着的士兵，那么进行一次厮杀，参与厮杀的三个士兵全部阵亡：A阵营的一个士兵阵亡，B阵营的一个士兵阵亡，这个不知道从哪个阵营来的士兵也阵亡。继续遍历。
 *  - 情况二：A阵营或B阵营已经没有士兵了。没有士兵的阵营暂时从地球上消失了。那么把当前遍历到的新士兵算作新的潜在幸存阵营，这个新阵营只有他一个人。继续遍历。
 * 大战结束，最后A和B阵营就是初始人数最多的阵营。判断一下A，B的人数是否超过所有人数的三分之一就行了。
 *
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();

        // cand是候选者，count是次数
        int cand1 = 0, count1 = 0;
        int cand2 = 0, count2 = 0;

        for (int num : nums) {
            if (count1 > 0 && num == cand1) { // 如果是第一个候选者
                count1++;
            } else if (count2 > 0 && num == cand2) { // 如果是第二个候选者
                count2++;
            } else if (count1 == 0) { // 还没有第一个候选者，或者之前的次数已经归0了
                cand1 = num;
                count1 = 1;
            } else if (count2 == 0) { // 还没有第二个候选者，或者之前的次数已经归0了
                cand2 = num;
                count2 = 1;
            } else { // 当前数与两个候选者都不同
                count1--;
                count2--;
            }
        }

        // 再次统计两个候选者的总票数
        count1 = count2 = 0;
        for (int num : nums) {
            if (cand1 == num) {
                count1++;
            } else if (cand2 == num) {
                count2++;
            }
        }

        // 加入结果
        if (count1 > nums.length / 3) {
            res.add(cand1);
        }
        if (count2 > nums.length / 3) {
            res.add(cand2);
        }

        return res;
    }
}