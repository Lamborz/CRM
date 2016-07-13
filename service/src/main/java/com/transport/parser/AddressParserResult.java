package com.transport.parser;

import lombok.Data;

import java.util.Map;

/**
 * Created by Victoria on 6/18/2016.
 */
@Data
public class AddressParserResult {
    Map<Integer, String > loadingAddress;
    Map<Integer, String > unLoadingAddress;
 }
