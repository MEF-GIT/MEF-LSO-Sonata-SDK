from typing import Any

def strip_nulls(obj: Any) -> Any:
    """
    Remove all null values from a nested structure (dicts and lists).
    """
    if isinstance(obj, dict):
        cleaned_dict = {}
        for k, v in obj.items():
            cleaned_value = strip_nulls(v)
            if cleaned_value is not None:
                cleaned_dict[k] = cleaned_value
        return cleaned_dict
    elif isinstance(obj, list):
        cleaned_list = [strip_nulls(i) for i in obj if i is not None]
        return cleaned_list if cleaned_list else None
    return obj