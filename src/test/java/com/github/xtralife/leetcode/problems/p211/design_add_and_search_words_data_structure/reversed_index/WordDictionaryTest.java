package com.github.xtralife.leetcode.problems.p211.design_add_and_search_words_data_structure.reversed_index;

import com.github.xtralife.leetcode.problems.p211.design_add_and_search_words_data_structure.reversed_index.WordDictionary;
import org.testng.annotations.Test;

public class WordDictionaryTest {
    @Test
    public void testWordDictionary() {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        assert !dictionary.search("pad");
        assert dictionary.search("bad");
        assert dictionary.search(".ad");
        assert dictionary.search("b..");
    }

    @Test
    public void testWordDictionary2() {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("at");
        dictionary.addWord("and");
        dictionary.addWord("an");
        dictionary.addWord("add");
        assert !dictionary.search("a");
        assert !dictionary.search(".at");
        dictionary.addWord("bat");
        assert dictionary.search(".at");
        assert dictionary.search("an.");
        assert !dictionary.search("a.d.");
        assert !dictionary.search("b.");
        assert dictionary.search("a.d");
        assert !dictionary.search(".");
    }
}
