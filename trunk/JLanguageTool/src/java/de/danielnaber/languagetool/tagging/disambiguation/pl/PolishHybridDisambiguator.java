/* LanguageTool, a natural language style checker 
 * Copyright (C) 2007 Daniel Naber (http://www.danielnaber.de)
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */

package de.danielnaber.languagetool.tagging.disambiguation.pl;

import java.io.IOException;

import de.danielnaber.languagetool.AnalyzedSentence;
import de.danielnaber.languagetool.tagging.disambiguation.Disambiguator;
import de.danielnaber.languagetool.tagging.disambiguation.rules.pl.PolishRuleDisambiguator;

/**
 * Hybrid chunker-disambiguator for Polish.
 * 
 * @author Marcin Miłkowski
 */

public class PolishHybridDisambiguator implements Disambiguator {

  private final Disambiguator chunker = new PolishChunker();
  private final Disambiguator disambiguator = new PolishRuleDisambiguator();

  /**
   * Calls two disambiguator classes: (1) a chunker; (2) a rule-based
   * disambiguator.
   */
  public final AnalyzedSentence disambiguate(AnalyzedSentence input)
      throws IOException {
    return disambiguator.disambiguate(chunker.disambiguate(input));
  }

}
