/*
MIT License

Copyright (c) 2018 Laurent BROUDOUX

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package com.github.lbroudoux.beer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author laurent
 */
public class CurryRepository {

   private static Map<String, Curry> beers = new HashMap<>();

   static {
      beers.put("Thai Green", new Curry("Thai Green", "Thailand", "coconut based", 4.2f, "available"));
      beers.put("Thai Red", new Curry("Thai Red", "Thailand", "coconut based", 3.8f, "available"));
      beers.put("Sour Fish", new Curry("Sour Fish", "Sri lanka", "Tamarind based", 4.1f, "out_of_stock"));
      beers.put("Chetinidad", new Curry("Chetinidad", "Chennai", "Unknonwn", 4.3f, "available"));
   }

   public static List<Curry> getBeers() {
      return new ArrayList<>(beers.values());
   }

   public static Curry findByName(String name) {
      if (beers.containsKey(name)) {
         return beers.get(name);
      }
      return null;
   }

   public static List<Curry> findByStatus(String status) {
      List<Curry> results = beers.values().stream()
            .filter(beer -> beer.getStatus().equals(status))
            .collect(Collectors.toList());

      return results;
   }
}
