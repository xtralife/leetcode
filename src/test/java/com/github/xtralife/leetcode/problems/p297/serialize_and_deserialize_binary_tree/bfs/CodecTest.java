package com.github.xtralife.leetcode.problems.p297.serialize_and_deserialize_binary_tree.bfs;

import org.testng.annotations.Test;

public class CodecTest {
    @Test
    public void testCodec() {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        String coded = codec.serialize(root);
        assert coded.equals("1|2|3|||4|5|||||");

        TreeNode actual = codec.deserialize(coded);
        assert actual.val == 1;
    }

    @Test
    public void testCodecNull() {
        Codec codec = new Codec();
        String coded = codec.serialize(null);
        assert coded.equals("");

        TreeNode actual = codec.deserialize(coded);
        assert actual.val == 1;
    }

    @Test
    public void testCodec12() {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        String coded = codec.serialize(root);
        assert coded.equals("1|2||||");

        TreeNode actual = codec.deserialize(coded);
        assert actual.val == 1;
    }
}
